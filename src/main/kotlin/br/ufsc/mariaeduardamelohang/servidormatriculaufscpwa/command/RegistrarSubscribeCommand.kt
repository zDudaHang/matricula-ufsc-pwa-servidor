package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
class RegistrarSubscribeCommand(
    private val em: EntityManager,
) {
    @Transactional
    fun execute(matricula: UUID, token: String) {
        val aluno = em.find(Aluno::class.java, matricula)
        aluno.token = token
        em.persist(aluno)
    }
}