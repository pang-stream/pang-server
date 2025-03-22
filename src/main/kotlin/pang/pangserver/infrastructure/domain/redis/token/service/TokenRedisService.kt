package pang.pangserver.infrastructure.domain.redis.token.service

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import pang.pangserver.infrastructure.security.exception.RefreshTokenNotMatchException
import java.util.UUID
import java.util.concurrent.TimeUnit

@Service
class TokenRedisService (
    private val redisTemplate: StringRedisTemplate,
) {
    fun storeRefreshToken(id: UUID, refreshToken: String) {
        redisTemplate.opsForValue().set("refresh_token:$id", refreshToken, 1, TimeUnit.DAYS)
    }

    fun getRefreshToken(id: UUID): String? {
        return redisTemplate.opsForValue().get("refresh_token:$id")
    }

    fun checkIfRefreshTokenIsCorrect(refreshToken: String, id: UUID)  {
        if (refreshToken != getRefreshToken(id))
            throw RefreshTokenNotMatchException()
    }
}