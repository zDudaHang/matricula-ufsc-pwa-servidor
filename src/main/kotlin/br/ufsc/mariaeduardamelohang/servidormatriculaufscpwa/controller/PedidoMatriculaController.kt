package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.controller

import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.DiaSemana
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Horario
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Turma
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.LimitesCargaHorariaDTO
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.dto.PedidoMatriculaDTO
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.PedidoMatriculaInput
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.service.PedidoMatriculaService
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator.RegistroPedidoMatriculaInputValidator
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator.throwIfInvalid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PedidoMatriculaController(
    private val service: PedidoMatriculaService,
    private val registroPedidoMatriculaInputValidator: RegistroPedidoMatriculaInputValidator,
    private val limitesCargaHorariaDTO: LimitesCargaHorariaDTO
) {

    @GetMapping("/pedidoMatricula")
    fun pedidoMatricula(): List<PedidoMatriculaDTO> {
        return service.buscarPedidoMatricula()
    }

    @PostMapping("/registrarPedidoMatricula", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun registrarPedidoMatricula(@RequestBody input: PedidoMatriculaInput): List<Turma> {
        registroPedidoMatriculaInputValidator.validate(input).throwIfInvalid()
        return service.registrarPedidoMatricula(input.turmas.filterNotNull())
    }

    @GetMapping("/turmas")
    fun turmas(): List<Turma> {
        return service.buscarTurmas()
    }

    @GetMapping("/horarios")
    fun horarios(): List<Horario> {
        return service.buscarHorarios()
    }

    @GetMapping("/diasSemana")
    fun diasSemana(): List<DiaSemana> {
        return service.buscarDiasSemana()
    }

    @GetMapping("/limitesCargaHoraria")
    fun limitesCargaHoraria(): LimitesCargaHorariaDTO {
        return limitesCargaHorariaDTO
    }
}