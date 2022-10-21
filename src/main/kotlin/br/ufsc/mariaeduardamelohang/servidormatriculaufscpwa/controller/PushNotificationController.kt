package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.controller

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.SubscriptionInput
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service.PushNotificationService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PushNotificationController(
    private val pushNotificationService: PushNotificationService
) {
    @PostMapping("/subscribe", consumes = [APPLICATION_JSON_VALUE])
    fun subscribe(@RequestBody subscription: SubscriptionInput) {
        pushNotificationService.subscribe(subscription)
    }

    @PutMapping("/unsubscribe")
    fun unsubscribe() {
        pushNotificationService.unsubscribe()
    }
}