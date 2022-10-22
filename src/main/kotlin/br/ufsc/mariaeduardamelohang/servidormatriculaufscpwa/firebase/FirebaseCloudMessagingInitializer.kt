package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.firebase

import com.google.auth.oauth2.GoogleCredentials.fromStream
import com.google.firebase.FirebaseApp.getApps
import com.google.firebase.FirebaseApp.initializeApp
import com.google.firebase.FirebaseOptions.builder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import javax.annotation.PostConstruct

@Component
class FirebaseCloudMessagingInitializer(
    @Value("\${app.firebase-configuration.credentials") private val credentials: String
) {
    private val logger: Logger = LoggerFactory.getLogger(FirebaseCloudMessagingInitializer::class.java)

    @PostConstruct
    fun initialize() {
        try {
            val credentialsStream: InputStream = ByteArrayInputStream(credentials.toByteArray())
            logger.info(credentials)
            val options = builder().setCredentials(fromStream(credentialsStream)).build()

            if (getApps().isEmpty()) {
                initializeApp(options)
                logger.info("Firebase application has been initialized")
            }
        } catch (e: IOException) {
            logger.error(e.message)
        }
    }
}