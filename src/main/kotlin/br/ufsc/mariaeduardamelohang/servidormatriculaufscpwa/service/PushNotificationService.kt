package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command.RegistrarSubscribeCommand
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.command.RemoverSubscribeTokenCommand
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.NotificacaoAluno
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.NotificationTypeEnum
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.SubscriptionInput
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.util.AuthUtils
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PushNotificationService(
    private val registrarSubscribeCommand: RegistrarSubscribeCommand,
    private val removerSubscribeTokenCommand: RemoverSubscribeTokenCommand
) {

    private val logger: Logger = LoggerFactory.getLogger(PushNotificationService::class.java)

    private val MESSAGE_PERDA_VAGA = "Edite o seu pedido de matrícula caso queira trocar de turma."
    private val TITLE_SUBSCRIBE_SUCCESS = "Notificações habilitadas com sucesso"

    fun notifyPerdaVaga(subscriptionToken: String, codigoTurma: String) {
        val title = "Entrada na fila de espera da turma $codigoTurma"
        val notificacao = NotificacaoAluno(title, NotificationTypeEnum.WARNING, MESSAGE_PERDA_VAGA)
        sendNotification(notificacao, subscriptionToken)
    }

    fun notifyGanhoVaga(subscriptionToken: String, codigoTurma: String) {
        val title = "Saída na fila de espera da turma $codigoTurma"
        val notificacao = NotificacaoAluno(title, NotificationTypeEnum.SUCCESS)
        sendNotification(notificacao, subscriptionToken)
    }

    private fun sendNotification(notificacao: NotificacaoAluno, subscriptionToken: String) {
        logger.debug("Sending notification (${notificacao.type.name}) to $subscriptionToken")

        val notification = Notification.builder()
            .setTitle(notificacao.title)
            .setBody(notificacao.message)
            .build()

        val message = Message.builder()
            .putAllData(notificacao.convertToNotificationData())
            .setToken(subscriptionToken)
            .setNotification(notification)
            .build()

        FirebaseMessaging.getInstance().send(message)
    }

    fun subscribe(subscriptionInput: SubscriptionInput) {
        val aluno = AuthUtils.getAlunoAutenticado()
        if (aluno !== null) {
            registrarSubscribeCommand.execute(aluno.matricula, subscriptionInput.token)
            val notificacao = NotificacaoAluno(TITLE_SUBSCRIBE_SUCCESS, NotificationTypeEnum.SUCCESS)
            sendNotification(notificacao, subscriptionInput.token)
        }
    }

    fun unsubscribe() {
        val aluno = AuthUtils.getAlunoAutenticado()
        if (aluno !== null) {
            removerSubscribeTokenCommand.execute(aluno.matricula)
        }
    }
}