package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.exception

import br.ufsc.bridge.platform.validation.form.errors.FormError
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = BAD_REQUEST, reason = "ValidationException")
class ValidationException(val errors: FormError<*>) : RuntimeException("ValidationException")