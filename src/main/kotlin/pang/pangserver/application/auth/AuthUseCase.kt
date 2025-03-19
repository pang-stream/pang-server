package pang.pangserver.application.auth

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import pang.pangserver.application.auth.data.request.SignInRequest
import pang.pangserver.application.auth.data.request.SignUpRequest
import pang.pangserver.application.auth.data.response.TokenResponse
import pang.pangserver.application.support.data.DataResponse
import pang.pangserver.application.support.data.Response
import pang.pangserver.infrastructure.domain.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.member.service.MemberService
import pang.pangserver.infrastructure.security.token.core.TokenProvider

@Component
@Transactional
class AuthUseCase(
    private val memberService: MemberService,
    private val provider: TokenProvider,
    private val encoder: BCryptPasswordEncoder
) {
    fun register(request: SignUpRequest): Response {
        memberService.validateMemberDuplicated(request.username, request.email)
        memberService.save(request.toEntity(encoder.encode(request.password)))
        return Response.noContent("register successful")
    }

    @Transactional(readOnly = true)
    fun login(request: SignInRequest): DataResponse<TokenResponse> {
        val member: MemberEntity = memberService.findByEmail(request.email)
        member.checkIfPasswordIsCorrect(encoder.encode(request.password))
        return DataResponse.ok("login successful", createTokens(member))
    }

    private fun createTokens(member: MemberEntity): TokenResponse {
        return TokenResponse(
            provider.generateAccess(member),
            provider.generatRefresh(member)
        )
    }
}