package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QAluno.aluno
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
class BuscarAlunoByMatriculaQuery(
    private val em: EntityManager,
) {
    @Transactional
    fun execute(matricula: UUID): Aluno? {
        return JPAQueryFactory(em)
            .selectFrom(aluno)
            .where(aluno.matricula.eq(matricula))
            .fetchOne()
    }
}