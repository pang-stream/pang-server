package pang.pangserver.presentation.auth

import org.springframework.web.bind.annotation.RestController
import pang.pangserver.application.auth.AuthUseCase
import pang.pangserver.application.auth.data.request.SignUpRequest

@RestController
class AuthController(
    private val useCase: AuthUseCase
) {
    fun signUp(request: SignUpRequest) {
        return useCase.register(request);
    }
}