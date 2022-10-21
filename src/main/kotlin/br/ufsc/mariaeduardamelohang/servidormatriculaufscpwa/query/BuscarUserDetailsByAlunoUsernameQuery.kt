package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.QAluno.aluno
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
class BuscarUserDetailsByAlunoUsernameQuery(
    private val em: EntityManager,
) {
    @Transactional
    fun execute(username: String): UserDetails? {
        return JPAQueryFactory(em).selectFrom(aluno)
            .where(aluno.nomeUsuario.eq(username))
            .fetchOne()
    }
}