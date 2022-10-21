package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.validator

import br.ufsc.bridge.platform.validation.form.errors.FormError
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.exception.ValidationException

fun <T> FormError<T>.throwIfInvalid() {
    if (!isValid) {
        throw ValidationException(this)
    }
}