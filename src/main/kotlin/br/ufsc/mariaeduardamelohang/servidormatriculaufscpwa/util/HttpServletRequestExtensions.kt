package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.util

import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.getAuthorizationHeader() : String? {
    return this.getHeader("Authorization")
}