package pang.pangserver.infrastructure.security.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import pang.pangserver.application.support.data.ErrorResponseSender
import pang.pangserver.application.support.exception.GlobalStatusCode
import pang.pangserver.core.exception.BasicException

@Component
class TokenExceptionHandlerFilter(
    private val errorSender: ErrorResponseSender
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BasicException) {
            errorSender.send(response, e.statusCode)
        } catch (e: Exception) {
            errorSender.send(response, GlobalStatusCode.INTERNAL_SERVER_ERROR)
        }
    }
}