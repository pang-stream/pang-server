package pang.pangserver.application.member

import org.springframework.stereotype.Component
import pang.pangserver.application.support.data.Response
import pang.pangserver.application.member.data.request.UpdateMemberRequest
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.rds.member.repository.MemberRepository
import pang.pangserver.infrastructure.security.token.support.MemberAuthenticationHolder

@Component
class MemberUseCase(
    private val repository: MemberRepository
) {
    fun update(request: UpdateMemberRequest): Response {
        TODO("업데이트")
    }
}