package pang.pangserver.infrastructure.security.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import pang.pangserver.application.support.token.enumeration.TokenType
import pang.pangserver.infrastructure.security.token.core.TokenValidator
import pang.pangserver.infrastructure.security.token.exception.EmptyTokenException

class TokenFilter (
    private val tokenValidator: TokenValidator
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val path: String = request.servletPath

        if (path.startsWith("/auth") || path.startsWith("/swagger-ui") || path.startsWith("/v3/api-docs")) {
            filterChain.doFilter(request, response)
            return
        }

        val token: String? = request.getHeader("Authorization")

        if (token.isNullOrEmpty() || !token.startsWith("Bearer ")) {
            throw EmptyTokenException()
        } else {
            tokenValidator.validateAll(token.removePrefix("Bearer "), TokenType.ACCESS_TOKEN)
        }
    }
}