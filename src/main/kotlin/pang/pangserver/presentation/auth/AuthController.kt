package pang.pangserver.presentation.auth

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pang.pangserver.application.auth.AuthUseCase
import pang.pangserver.application.auth.data.request.SignInRequest
import pang.pangserver.application.auth.data.request.SignUpRequest
import pang.pangserver.application.auth.data.response.TokenResponse
import pang.pangserver.application.support.data.DataResponse
import pang.pangserver.application.support.data.Response

@RestController
@RequestMapping("/auth")
class AuthController(
    private val useCase: AuthUseCase
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): Response {
        return useCase.register(request);
    }

    @PostMapping("/sign-in")
    fun signIn(request: SignInRequest): DataResponse<TokenResponse> {
        return useCase.login(request)
    }
}