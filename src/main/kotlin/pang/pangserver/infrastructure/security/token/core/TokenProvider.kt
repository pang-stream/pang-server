package pang.pangserver.infrastructure.security.token.core

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import pang.pangserver.application.support.enumeration.TokenType
import pang.pangserver.infrastructure.domain.member.entity.MemberEntity
import pang.pangserver.infrastructure.security.token.properties.TokenProperties
import java.lang.System.currentTimeMillis
import java.util.*

@Component
class TokenProvider(
    private val properties: TokenProperties,
) {
    fun generate(tokenType: TokenType, member: MemberEntity, expire: Long): String {
        return Jwts.builder()
            .claim("category", tokenType.value)
            .claim("email", member.email)
            .claim("role", member.role)
            .issuedAt(Date(currentTimeMillis()))
            .expiration(Date(currentTimeMillis() + expire))
            .signWith(properties.secretKey())
            .compact()
    }
}