package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.PedidoMatriculaPrimaryKey

data class AlunoNotificacaoDTO(
    val idPedidoMatricula: PedidoMatriculaPrimaryKey,
    val subscriptionToken: String,
    val nomeUsuario: String,
    val codigoTurma: String
)
