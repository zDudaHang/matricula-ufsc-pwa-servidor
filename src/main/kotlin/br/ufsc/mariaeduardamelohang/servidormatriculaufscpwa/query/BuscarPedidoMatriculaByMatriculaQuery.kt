package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QPedidoMatricula.pedidoMatricula
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QTurma.turma
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.PedidoMatriculaDTO
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
class BuscarPedidoMatriculaByMatriculaQuery(
    private val em: EntityManager,
) {

    @Transactional
    fun execute(matricula: UUID): List<PedidoMatriculaDTO> {
        return JPAQueryFactory(em)
            .select(Projections.constructor(PedidoMatriculaDTO::class.java, turma, pedidoMatricula.posicao))
            .from(pedidoMatricula)
            .innerJoin(turma).on(pedidoMatricula.id.turma.codigo.eq(turma.codigo))
            .where(pedidoMatricula.id.aluno.matricula.eq(matricula))
            .fetch()
    }
}