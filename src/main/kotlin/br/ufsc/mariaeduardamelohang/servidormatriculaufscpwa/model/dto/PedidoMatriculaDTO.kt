package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Turma

data class PedidoMatriculaDTO(
    val turma: Turma,
    val posicao: Int
)
