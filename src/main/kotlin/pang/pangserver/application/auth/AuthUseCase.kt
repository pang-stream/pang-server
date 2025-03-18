package pang.pangserver.application.auth

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import pang.pangserver.application.auth.data.request.SignUpRequest
import pang.pangserver.infrastructure.domain.member.service.MemberService

@Component
@Transactional
class AuthUseCase(
    private val memberService: MemberService,
) {
    fun register(request: SignUpRequest) {
        memberService.save(request.toEntity())
    }
}