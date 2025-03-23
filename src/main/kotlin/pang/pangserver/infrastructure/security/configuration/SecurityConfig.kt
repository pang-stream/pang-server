package pang.pangserver.infrastructure.security.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import pang.pangserver.infrastructure.security.filter.TokenExceptionHandlerFilter
import pang.pangserver.infrastructure.security.filter.TokenFilter
import pang.pangserver.infrastructure.security.token.core.TokenValidator

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val tokenValidator: TokenValidator,
    private val tokenExceptionHandlerFilter: TokenExceptionHandlerFilter
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin{ it.disable() }
            .httpBasic{ it.disable() }
            .cors { it.disable() }
            .authorizeHttpRequests{ request ->
                request
                    .requestMatchers("/auth/*").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterAfter(TokenFilter(tokenValidator), UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(tokenExceptionHandlerFilter, TokenFilter::class.java)
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}