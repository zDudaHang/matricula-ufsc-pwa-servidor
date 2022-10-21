package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.controller

import br.ufsc.bridge.platform.validation.form.errors.FormError
import br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.exception.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler
    fun handleValidationException(e: ValidationException): ResponseEntity<FormError<*>> {
        return ResponseEntity(e.errors, HttpStatus.BAD_REQUEST)
    }
}