package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.FileCopyUtils
import java.nio.charset.StandardCharsets
import javax.persistence.EntityManager

@Component
class TriggersCreator(
    private val em: EntityManager
) {
    private val SQL_TRIGGERS_PATH = "triggers.sql"
    private val logger: Logger = LoggerFactory.getLogger(TriggersCreator::class.java)

    @EventListener
    @Transactional
    fun onApplicationEvent(event: ContextRefreshedEvent?) {
        logger.info("Creating triggers...")
        try {
            javaClass.classLoader.getResourceAsStream(SQL_TRIGGERS_PATH).use {
                if (it != null) {
                    val sqlAsBytes = FileCopyUtils.copyToByteArray(it)
                    val insertSQL = String(sqlAsBytes, StandardCharsets.UTF_8)
                    logger.debug(insertSQL)
                    em.createNativeQuery(insertSQL).executeUpdate()
                    logger.info("Triggers - OK")
                }
            }
        } catch (e: Exception) {
            logger.error(e.message)
        }
    }
}