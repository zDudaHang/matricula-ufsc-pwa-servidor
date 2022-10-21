package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.LoginInput
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val authenticationManager: AuthenticationManager
) {
    fun authenticate(input: LoginInput) : Authentication {
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
            input.nomeUsuario,
            input.senha
        )
        val authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)
        SecurityContextHolder.getContext().authentication = authentication
        return authentication
    }
}