package pang.pangserver.infrastructure.security.token.core

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import pang.pangserver.application.support.token.enumeration.TokenType
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.redis.token.service.TokenRedisService
import pang.pangserver.infrastructure.security.token.properties.TokenProperties
import java.lang.System.currentTimeMillis
import java.util.*

@Component
class TokenProvider(
    private val properties: TokenProperties,
    private val tokenRedisService: TokenRedisService
) {
    private fun generate(tokenType: TokenType, member: MemberEntity, expire: Long): String {
        return Jwts.builder()
            .claim("category", tokenType.value)
            .claim("username", member.username)
            .claim("role", member.role)
            .issuedAt(Date(currentTimeMillis()))
            .expiration(Date(currentTimeMillis() + expire))
            .signWith(properties.secretKey())
            .compact()
    }

    fun generateAccess(member: MemberEntity): String
        = generate(TokenType.ACCESS_TOKEN, member, properties.access)

    fun generatRefresh(member: MemberEntity): String {
        val refreshToken = generate(TokenType.REFRESH_TOKEN, member, properties.refresh)
        tokenRedisService.storeRefreshToken(member.id!!, refreshToken)
        return refreshToken
    }
}