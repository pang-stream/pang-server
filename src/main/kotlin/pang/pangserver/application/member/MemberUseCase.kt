package pang.pangserver.application.member

import org.springframework.stereotype.Component
import pang.pangserver.application.support.data.Response
import pang.pangserver.application.member.data.request.UpdateMemberRequest
import pang.pangserver.infrastructure.domain.rds.member.service.MemberService
import pang.pangserver.infrastructure.security.token.support.MemberAuthenticationHolder

@Component
class MemberUseCase(
    private val memberService: MemberService,
) {
    fun patchInfo(request: UpdateMemberRequest): Response {
        val member = MemberAuthenticationHolder.current()
        member.updateInfo(request.nickname, request.gender, request.birthDay, request.isAlarm)
        memberService.save(member)
        return Response.ok("업데이트 성공")
    }
}