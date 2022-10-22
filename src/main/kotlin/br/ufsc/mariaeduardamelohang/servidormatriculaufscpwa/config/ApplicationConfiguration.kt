package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.config

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.LimitesCargaHorariaDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration(
    @Value("\${app.matricula.carga-horaria.min}") private val cargaHorariaMinima : Int,
    @Value("\${app.matricula.carga-horaria.max}") private val cargaHorariaMaxima: Int
) {
    @Bean
    fun limitesCargaHoraria(): LimitesCargaHorariaDTO {
        return LimitesCargaHorariaDTO(cargaHorariaMinima, cargaHorariaMaxima)
    }
}