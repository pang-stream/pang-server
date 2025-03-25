package pang.pangserver.application.member.data.request

import pang.pangserver.infrastructure.domain.rds.member.enumeration.MemberGender
import java.time.LocalDate

data class UpdateMemberRequest(
    var nickname: String? = null,
    var age: Int? = null,
    var postPassword: String? = null,
    var password: String? = null,
    var gender: MemberGender? = null,
    var birthday: LocalDate? = null
)
