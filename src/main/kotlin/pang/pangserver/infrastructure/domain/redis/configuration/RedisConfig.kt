package pang.pangserver.infrastructure.domain.redis.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
class RedisConfig(
    private val properties: RedisProperties,
) {
    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val config = RedisStandaloneConfiguration().apply {
            hostName = properties.host
            port = properties.port
            password = org.springframework.data.redis.connection.RedisPassword.of(properties.password)
        }
        return LettuceConnectionFactory(config)
    }

    @Bean
    fun stringRedisTemplate(): StringRedisTemplate {
        return StringRedisTemplate(redisConnectionFactory())
    }

}