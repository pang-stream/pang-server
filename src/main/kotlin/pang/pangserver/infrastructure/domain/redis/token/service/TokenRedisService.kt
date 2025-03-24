package pang.pangserver.infrastructure.domain.redis.token.service

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import pang.pangserver.infrastructure.security.exception.RefreshTokenNotMatchException
import java.util.concurrent.TimeUnit

@Service
class TokenRedisService (
    private val redisTemplate: StringRedisTemplate,
) {
    fun storeRefreshToken(key: String, refreshToken: String) {
        redisTemplate.opsForValue().set("refresh_token:$key", refreshToken, 1, TimeUnit.DAYS)
    }

    fun getRefreshToken(key: String): String? {
        return redisTemplate.opsForValue().get("refresh_token:$key")
    }

    fun checkIfRefreshTokenIsCorrect(refreshToken: String, key: String)  {
        if (refreshToken != getRefreshToken(key))
            throw RefreshTokenNotMatchException()
    }
}