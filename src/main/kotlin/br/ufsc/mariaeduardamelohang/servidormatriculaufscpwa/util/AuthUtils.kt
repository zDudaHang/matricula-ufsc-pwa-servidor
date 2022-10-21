package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.util

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Aluno
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

class AuthUtils {
    companion object {
        fun getAlunoAutenticado() : Aluno? {
            val principal = SecurityContextHolder.getContext().authentication.principal
            return if (principal is UserDetails) {
                val aluno = principal as Aluno
                aluno
            } else {
                null
            }
        }
    }
}