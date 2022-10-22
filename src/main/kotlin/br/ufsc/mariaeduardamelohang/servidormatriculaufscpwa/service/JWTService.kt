package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm.HS256
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Date
import java.util.UUID

@Service
class JWTService(
    @Value("\${app.jwt-secret}") val secret: String
) {

    fun generateToken(matricula: UUID): String {
        return Jwts.builder()
            .setSubject(matricula.toString())
            .setIssuedAt(Date())
            .signWith(HS256, secret)
            .compact()
    }

    fun isAccessTokenValid(accessToken: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(accessToken)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getMatricula(accessToken: String): UUID? {
        val body = Jwts.parser().setSigningKey(secret).parseClaimsJws(accessToken).body
        return UUID.fromString(body.subject)
    }
}