package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.firebase

import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.firebase.FirebaseApp.getApps
import com.google.firebase.FirebaseApp.initializeApp
import com.google.firebase.FirebaseOptions.builder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.IOException
import java.net.URI
import javax.annotation.PostConstruct

@Component
class FirebaseCloudMessagingInitializer(
    @Value("\${app.firebase-configuration.project-id") private val projectId: String,
    @Value("\${app.firebase-configuration.private-key-id") private val privateKeyId: String,
    @Value("\${app.firebase-configuration.private-key") private val privateKey: String,
    @Value("\${app.firebase-configuration.client-email") private val clientEmail: String,
    @Value("\${app.firebase-configuration.client-id") private val clientId: String,
    @Value("\${app.firebase-configuration.token-uri") private val tokenURI: String,
) {
    private val logger: Logger = LoggerFactory.getLogger(FirebaseCloudMessagingInitializer::class.java)

    @PostConstruct
    fun initialize() {
        try {
            val credentials = ServiceAccountCredentials.newBuilder()
                .setProjectId(projectId)
                .setPrivateKeyId(privateKeyId)
                .setPrivateKeyString(privateKey)
                .setClientEmail(clientEmail)
                .setClientId(clientId)
                .setTokenServerUri(URI.create(tokenURI))
                .build()

            val options = builder().setCredentials(credentials).build()
            if (getApps().isEmpty()) {
                initializeApp(options)
                logger.info("Firebase application has been initialized")
            }
        } catch (e: IOException) {
            logger.error(e.message)
        }
    }
}