package pang.pangserver.infrastructure.security.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import pang.pangserver.infrastructure.security.token.properties.TokenProperties

@Configuration
@EnableConfigurationProperties(TokenProperties::class)
class TokenConfig {}