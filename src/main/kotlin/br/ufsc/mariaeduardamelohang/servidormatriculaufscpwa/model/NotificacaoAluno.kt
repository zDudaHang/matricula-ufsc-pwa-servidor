package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model

data class NotificacaoAluno(
    val title: String,
    val type: NotificationTypeEnum,
    val message: String? = null
) {
    fun convertToNotificationData(): MutableMap<String, String?> {
        return mutableMapOf("message" to (message ?: ""), "type" to type.desc, "title" to title)
    }
}
