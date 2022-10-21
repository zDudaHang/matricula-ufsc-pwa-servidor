package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QAluno.aluno
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class BuscarAlunoByUsernameQuery(
    private val em: EntityManager
) {
    fun execute(username: String): Aluno? {
        return JPAQueryFactory(em)
            .selectFrom(aluno)
            .where(aluno.nomeUsuario.eq(username))
            .fetchFirst()
    }
}