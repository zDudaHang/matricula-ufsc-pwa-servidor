package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator

import br.ufsc.bridge.platform.validation.form.errors.FormError
import br.ufsc.bridge.platform.validation.form.errors.FormErrorImpl
import br.ufsc.bridge.platform.validation.rules.Rules.required
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.input.LoginInput
import org.springframework.stereotype.Component

@Component
class LoginInputValidator {
    fun validate(input: LoginInput): FormError<LoginInput> {
        val error = FormErrorImpl(input)

        error.check(LoginInput::nomeUsuario, required)
        error.check(LoginInput::senha, required)

        return error
    }
}