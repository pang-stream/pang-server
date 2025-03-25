package pang.pangserver.application.auth.data.request

import jakarta.validation.constraints.Email
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.rds.member.enumeration.MemberRole

data class SignUpRequest(
    @Email val email: String,
    val username: String,
    val password: String,
) {
    fun toEntity(encodedPassword: String): MemberEntity {
        return MemberEntity(
            email = email,
            username = username,
            password = encodedPassword,
            role = MemberRole.MEMBER
        )
    }
}