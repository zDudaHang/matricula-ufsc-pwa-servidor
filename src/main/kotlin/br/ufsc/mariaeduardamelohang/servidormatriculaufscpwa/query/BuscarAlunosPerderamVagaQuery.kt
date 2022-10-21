package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QAluno.aluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QPedidoMatricula.pedidoMatricula
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QTurma.turma
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.AlunoNotificacaoDTO
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityManager

@Repository
class BuscarAlunosPerderamVagaQuery(
    private val em: EntityManager
) {
    fun execute(codigoTurmas: List<String>, matriculaDeveSerIgnorada: UUID): List<AlunoNotificacaoDTO> {
        return JPAQueryFactory(em)
            .select(Projections.constructor(AlunoNotificacaoDTO::class.java, pedidoMatricula.id, aluno.token, aluno.nomeUsuario, turma.codigo))
            .from(pedidoMatricula)
            .innerJoin(aluno).on(pedidoMatricula.id.aluno.matricula.eq(aluno.matricula))
            .innerJoin(turma).on(turma.codigo.eq(pedidoMatricula.id.turma.codigo))
            .where(
                pedidoMatricula.deveNotificarAlunoPerdeuVaga.isTrue
                    .and(aluno.token.isNotNull)
                    .and(aluno.matricula.ne(matriculaDeveSerIgnorada))
                    .and(turma.codigo.`in`(codigoTurmas))
            )
            .fetch()
    }
}