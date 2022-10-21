package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
class RemoverSubscribeTokenCommand(
    private val em: EntityManager
) {
    @Transactional
    fun execute(matricula: UUID) {
        val aluno = em.find(Aluno::class.java, matricula)
        aluno.token = null
        em.persist(aluno)
    }
}
