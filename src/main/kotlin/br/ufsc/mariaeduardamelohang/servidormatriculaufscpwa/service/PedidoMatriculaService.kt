package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command.AtualizarAlunosNotificadosCommand
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command.RegistrarPedidoMatriculaCommand
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.RegistroPedidoMatriculaResult
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.DiaSemana
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Horario
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.PedidoMatriculaPrimaryKey
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Turma
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.PedidoMatriculaDTO
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarAlunosGanharamVagaQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarAlunosPerderamVagaQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarDiasSemanaQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarHorariosQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarPedidoMatriculaByMatriculaQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarTurmasQuery
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.util.AuthUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class PedidoMatriculaService(
    private val buscarPedidoMatriculaByMatriculaQuery: BuscarPedidoMatriculaByMatriculaQuery,
    private val buscarTurmasQuery: BuscarTurmasQuery,
    private val registrarPedidoMatriculaCommand: RegistrarPedidoMatriculaCommand,
    private val atualizarAlunosNotificadosCommand: AtualizarAlunosNotificadosCommand,
    private val buscarAlunosPerderamVagaQuery: BuscarAlunosPerderamVagaQuery,
    private val buscarAlunosGanharamVagaQuery: BuscarAlunosGanharamVagaQuery,
    private val buscarHorariosQuery: BuscarHorariosQuery,
    private val buscarDiasSemanaQuery: BuscarDiasSemanaQuery,
    private val pushNotificationService: PushNotificationService
) {

    private val logger: Logger = LoggerFactory.getLogger(PedidoMatriculaService::class.java)

    fun buscarTurmas(): List<Turma> {
        return buscarTurmasQuery.execute()
    }

    fun buscarPedidoMatricula(): List<PedidoMatriculaDTO> {
        val aluno = AuthUtils.getAlunoAutenticado()
        return if (aluno != null) {
            buscarPedidoMatriculaByMatriculaQuery.execute(aluno.matricula)
        } else {
            mutableListOf()
        }
    }

    fun registrarPedidoMatricula(codigosTurmas: List<String>): List<Turma> {
        val aluno = AuthUtils.getAlunoAutenticado()
        return if (aluno != null) {
            val result = salvarPedidoMatricula(codigosTurmas, aluno)
            notificarAlunos(result, aluno.matricula)
            return result.getTurmasMatriculadas()
        } else listOf()
    }

    @Transactional
    private fun salvarPedidoMatricula(codigosTurmas: List<String>, aluno: Aluno): RegistroPedidoMatriculaResult {
        val codigosTurmasJahMatriculadas = buscarPedidoMatriculaByMatriculaQuery.execute(aluno.matricula).map { it.turma.codigo }
        return registrarPedidoMatriculaCommand.execute(codigosTurmas, aluno, codigosTurmasJahMatriculadas.toSet())
    }

    private fun notificarAlunos(result: RegistroPedidoMatriculaResult, matriculaDeveSerIgnorada: UUID) {
        val pkVagasPerdidas = notificarPerdaVaga(result.turmasNovas.map { it.codigo }, matriculaDeveSerIgnorada)
        val pkVagasGanhas = notificarGanhoVaga(result.turmasRemovidas.map { it.codigo }, matriculaDeveSerIgnorada)
        atualizarAlunosNotificadosCommand.execute(pkVagasGanhas, pkVagasPerdidas)
    }

    private fun notificarPerdaVaga(codigoTurmasNovas: List<String>, matriculaDeveSerIgnorada: UUID): List<PedidoMatriculaPrimaryKey> {
        val alunosPerderamVaga = buscarAlunosPerderamVagaQuery.execute(codigoTurmasNovas, matriculaDeveSerIgnorada)
        alunosPerderamVaga.forEach {
            logger.debug("Notificando o aluno ${it.nomeUsuario} porque perdeu a vaga na turma ${it.codigoTurma}")
            pushNotificationService.notifyPerdaVaga(it.subscriptionToken, it.codigoTurma)
        }
        return alunosPerderamVaga.map { it.idPedidoMatricula }
    }

    private fun notificarGanhoVaga(codigoTurmasRemovidas: List<String>, matriculaDeveSerIgnorada: UUID): List<PedidoMatriculaPrimaryKey> {
        val alunosGanharamVaga = buscarAlunosGanharamVagaQuery.execute(codigoTurmasRemovidas, matriculaDeveSerIgnorada)
        alunosGanharamVaga.forEach {
            logger.debug("Notificando o aluno ${it.nomeUsuario} porque saiu da fila de espera da turma ${it.codigoTurma}")
            pushNotificationService.notifyGanhoVaga(it.subscriptionToken, it.codigoTurma)
        }
        return alunosGanharamVaga.map { it.idPedidoMatricula }
    }

    fun buscarHorarios(): List<Horario> {
        return buscarHorariosQuery.execute()
    }

    fun buscarDiasSemana(): List<DiaSemana> {
        return buscarDiasSemanaQuery.execute()
    }
}