package pang.pangserver.infrastructure.security.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig() {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin{ it.disable() }
            .httpBasic{ it.disable() }
            .cors{ it.disable() }

            .authorizeHttpRequests{ request ->
                request
                    .requestMatchers("/auth/*").permitAll()
                    .requestMatchers("user/sign-up", "/user/sign-up/*").permitAll()
                    .requestMatchers("/school/*").permitAll()
                    .anyRequest().authenticated()
            }
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}