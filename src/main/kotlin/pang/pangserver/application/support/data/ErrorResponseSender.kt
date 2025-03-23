package pang.pangserver.application.support.data

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import pang.pangserver.core.exception.StatusCode

@Component
class ErrorResponseSender(
    private val objectMapper: ObjectMapper
) {
    fun send(response: HttpServletResponse, statusCode: StatusCode) {
        response.status = statusCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "UTF-8"
        response.writer.write(objectMapper.writeValueAsString(statusCode))
    }
}