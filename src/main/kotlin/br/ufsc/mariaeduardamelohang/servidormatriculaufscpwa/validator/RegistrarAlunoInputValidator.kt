package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator

import br.ufsc.bridge.platform.validation.form.errors.FormError
import br.ufsc.bridge.platform.validation.form.errors.FormErrorImpl
import br.ufsc.bridge.platform.validation.rules.Rules.required
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.RegistrarAlunoInput
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.query.BuscarAlunoByUsernameQuery
import org.springframework.stereotype.Component

@Component
class RegistrarAlunoInputValidator(
    private val buscarAlunoByUsernameQuery: BuscarAlunoByUsernameQuery
) {
    fun validate(input: RegistrarAlunoInput): FormError<RegistrarAlunoInput> {
        val error = FormErrorImpl(input)

        error.check(RegistrarAlunoInput::nomeUsuario, required)
        error.check(RegistrarAlunoInput::senha, required)

        if (error.isValid) {
            val aluno = buscarAlunoByUsernameQuery.execute(input.nomeUsuario!!)
            if (aluno != null) {
                error.fieldError(
                    RegistrarAlunoInput::nomeUsuario,
                    "Nome de usuário já existente"
                )
            }
        }

        return error
    }
}