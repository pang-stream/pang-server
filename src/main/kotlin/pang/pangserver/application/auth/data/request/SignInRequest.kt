package pang.pangserver.application.auth.data.request

data class SignInRequest(
    val email: String,
    val password: String
)