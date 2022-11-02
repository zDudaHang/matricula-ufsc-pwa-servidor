package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator

import br.ufsc.bridge.platform.validation.form.errors.FormError
import br.ufsc.bridge.platform.validation.form.errors.FormErrorImpl
import br.ufsc.bridge.platform.validation.rules.Rules.required
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database.Turma
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.PedidoMatriculaInput
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator.model.ConflitoKey
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Component
class RegistroPedidoMatriculaInputValidator(
    private val em: EntityManager,
    @Value("\${app.matricula.carga-horaria.min}") private val cargaHorariaMinima: Int,
    @Value("\${app.matricula.carga-horaria.max}") private val cargaHorariaMaxima: Int
) {

    @Transactional
    fun validate(input: PedidoMatriculaInput): FormError<PedidoMatriculaInput> {
        val error = FormErrorImpl(input)

        error.check(PedidoMatriculaInput::turmas, required)

        if (error.isValid) {
            val turmas: MutableList<Turma> = mutableListOf()
            input.turmas.forEach {
                if (error.isValid) {
                    if (it == null) {
                        error.fieldError(PedidoMatriculaInput::turmas, "Turma com código $it não encontrada")
                    } else {
                        val turma = em.find(Turma::class.java, it)
                        if (turma == null) error.fieldError(PedidoMatriculaInput::turmas, "Turma com código $it não encontrada")
                        else turmas.add(turma)
                    }
                }
            }

            if (error.isValid) {
                val horariosComConflito = turmas
                    .map { it.horarios }
                    .flatten()
                    .groupBy { ConflitoKey(it.id.diaSemana.id, it.id.horario.id) }
                    .filter { it.value.size > 1 }

                if (horariosComConflito.isNotEmpty()) {
                    error.fieldError(PedidoMatriculaInput::turmas, "Conflito(s) de horário encontrado(s)")
                } else {
                    val cargaHorariaTotal = turmas.sumOf { it.disciplina.cargaHoraria }
                    if (cargaHorariaTotal < cargaHorariaMinima) {
                        error.fieldError(PedidoMatriculaInput::turmas, "A carga horária mínima é de $cargaHorariaMinima H/A")
                    } else if (cargaHorariaTotal > cargaHorariaMaxima) {
                        error.fieldError(PedidoMatriculaInput::turmas, "A carga horária máxima é de $cargaHorariaMaxima H/A")
                    }
                }
            }
        }

        return error
    }
}