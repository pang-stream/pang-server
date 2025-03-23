package pang.pangserver.infrastructure.security.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import pang.pangserver.application.support.token.enumeration.TokenType
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberDetails
import pang.pangserver.infrastructure.domain.rds.member.exception.MemberNotFoundException
import pang.pangserver.infrastructure.domain.rds.member.repository.MemberRepository
import pang.pangserver.infrastructure.security.token.core.TokenParser
import pang.pangserver.infrastructure.security.token.core.TokenValidator
import pang.pangserver.infrastructure.security.token.exception.EmptyTokenException

@Component
class TokenFilter (
    private val tokenParser: TokenParser,
    private val tokenValidator: TokenValidator,
    private val memberRepository: MemberRepository
): OncePerRequestFilter() {
    companion object {
        private const val TOKEN_SECURE_TYPE = "Bearer "
    }
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (!request.getHeader(HttpHeaders.AUTHORIZATION).isNullOrEmpty()) {
            val token: String? = request.getHeader("Authorization")
            if (token.isNullOrEmpty() || !token.startsWith(TOKEN_SECURE_TYPE)) throw EmptyTokenException()
            tokenValidator.validateAll(token.removePrefix(TOKEN_SECURE_TYPE), TokenType.ACCESS_TOKEN)

            val member = MemberDetails(memberRepository.findByUsername(tokenParser.findUsername(token))?: throw MemberNotFoundException())
            SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(member, null, member.authorities)
        }

        filterChain.doFilter(request, response)
    }
}