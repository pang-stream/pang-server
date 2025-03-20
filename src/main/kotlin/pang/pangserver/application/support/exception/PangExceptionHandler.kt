package pang.pangserver.application.support.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import pang.pangserver.application.support.data.ErrorResponse
import pang.pangserver.core.exception.BasicException

@RestControllerAdvice
class PangExceptionHandler {
    @ExceptionHandler(BasicException::class)
    fun basicExceptionHandler(e: BasicException): ResponseEntity<ErrorResponse> {
        return ErrorResponse.responseEntity(e.statusCode);
    }
}