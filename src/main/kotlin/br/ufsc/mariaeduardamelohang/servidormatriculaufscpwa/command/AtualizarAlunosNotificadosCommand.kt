package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.PedidoMatricula
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.PedidoMatriculaPrimaryKey
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
class AtualizarAlunosNotificadosCommand(
    private val em: EntityManager
) {
    @Transactional
    fun execute(pkVagasPerdidas: List<PedidoMatriculaPrimaryKey>, pkVagasGanhas: List<PedidoMatriculaPrimaryKey>) {
        pkVagasPerdidas.forEach {
            val pedidoMatricula = em.find(PedidoMatricula::class.java, it)
            pedidoMatricula.isDeveNotificarAlunoPerdeuVaga = false
            em.persist(pedidoMatricula)
        }

        pkVagasGanhas.forEach {
            val pedidoMatricula = em.find(PedidoMatricula::class.java, it)
            pedidoMatricula.isDeveNotificarAlunoGanhouVaga = false
            em.persist(pedidoMatricula)
        }
    }
}