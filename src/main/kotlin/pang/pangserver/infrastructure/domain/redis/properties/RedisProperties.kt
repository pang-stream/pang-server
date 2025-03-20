package pang.pangserver.infrastructure.domain.redis.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.data.redis")
data class RedisProperties(
    val port: Int,
    val host: String,
    val password: String,
)