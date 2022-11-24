package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.RegistrarAlunoInput
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.transaction.Transactional
import kotlin.random.Random

@Repository
class RegistrarAlunoCommand(
    private val em: EntityManager,
) {

    @Transactional
    fun execute(input: RegistrarAlunoInput): String {
        val aluno = Aluno()
        aluno.nomeUsuario = input.nomeUsuario
        aluno.senha = input.senha
        aluno.iaa = Random.nextInt(1,9)

        em.persist(aluno)

        return aluno.nomeUsuario
    }
}