package pang.pangserver.presentation.member

import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pang.pangserver.application.member.MemberUseCase
import pang.pangserver.application.member.data.request.UpdateMemberRequest
import pang.pangserver.application.support.data.Response

@RestController
@RequestMapping("/member")
class MemberController(
    private val useCase: MemberUseCase
) {
    @PatchMapping
    fun update(@RequestBody request: UpdateMemberRequest): Response {
        return useCase.update(request);
    }
}