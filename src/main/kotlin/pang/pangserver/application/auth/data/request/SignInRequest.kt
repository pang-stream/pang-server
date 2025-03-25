package pang.pangserver.application.auth.data.request

import jakarta.validation.constraints.Email

data class SignInRequest(
    @Email val email: String,
    val password: String
)