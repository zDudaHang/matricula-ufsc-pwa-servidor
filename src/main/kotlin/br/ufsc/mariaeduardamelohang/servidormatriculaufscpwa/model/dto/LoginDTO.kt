package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto

data class LoginDTO(
    val subscriptionToken: String? = null,
    val accessToken: String? = null,
    val iaa: Int? = null
)