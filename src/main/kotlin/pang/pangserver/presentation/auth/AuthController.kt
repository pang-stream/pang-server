package pang.pangserver.presentation.auth

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pang.pangserver.application.auth.AuthUseCase
import pang.pangserver.application.auth.data.request.RefreshRequest
import pang.pangserver.application.auth.data.request.SignInRequest
import pang.pangserver.application.auth.data.request.SignUpRequest
import pang.pangserver.application.auth.data.response.TokenResponse
import pang.pangserver.application.support.data.DataResponse
import pang.pangserver.application.support.data.Response

@Tag(name = "Auth", description = "인증/인가")
@RestController
@RequestMapping("/auth")
class AuthController(
    private val useCase: AuthUseCase
) {
    @Operation(summary = "Sign Up")
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): Response {
        return useCase.register(request);
    }

    @Operation(summary = "Login")
    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): DataResponse<TokenResponse> {
        return useCase.login(request)
    }

    @Operation(summary = "Token Refresh")
    @PostMapping("/refresh")
    fun refresh(@RequestBody request: RefreshRequest): DataResponse<TokenResponse> {
        return useCase.refresh(request)
    }
}