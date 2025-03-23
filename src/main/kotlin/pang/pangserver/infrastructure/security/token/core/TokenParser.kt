package pang.pangserver.infrastructure.security.token.core

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import pang.pangserver.application.support.token.enumeration.TokenType
import pang.pangserver.infrastructure.security.token.properties.TokenProperties
import java.util.*

@Component
class TokenParser(
    private val properties: TokenProperties
) {
    fun findType(token: String): TokenType {
        return TokenType.toTokenType(createClaims(token)["category"].toString())
    }

    fun findExpiration(token: String): Date {
        return createClaims(token).expiration
    }

    fun findUsername(token: String): String {
        return createClaims(token)["username"].toString()
    }

    private fun createClaims(token: String): Claims {
        return Jwts.parser().verifyWith(properties.secretKey()).build().parseSignedClaims(token).payload
    }
}