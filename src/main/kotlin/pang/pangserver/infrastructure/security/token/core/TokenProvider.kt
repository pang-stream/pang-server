package pang.pangserver.infrastructure.security.token.core

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import pang.pangserver.application.support.token.enumeration.TokenType
import pang.pangserver.infrastructure.domain.member.entity.MemberEntity
import pang.pangserver.infrastructure.security.token.properties.TokenProperties
import java.lang.System.currentTimeMillis
import java.util.*

@Component
class TokenProvider(
    private val properties: TokenProperties,
) {
    private fun generate(tokenType: TokenType, member: MemberEntity, expire: Long): String {
        return Jwts.builder()
            .claim("category", tokenType.value)
            .claim("email", member.email)
            .claim("role", member.role)
            .issuedAt(Date(currentTimeMillis()))
            .expiration(Date(currentTimeMillis() + expire))
            .signWith(properties.secretKey())
            .compact()
    }

    fun generateAccess(member: MemberEntity): String
        = generate(TokenType.ACCESS_TOKEN, member, properties.access)

    fun generatRefresh(member: MemberEntity): String
            = generate(TokenType.REFRESH_TOKEN, member, properties.refresh)

}