package pang.pangserver.infrastructure.domain.rds.member.exception

import pang.pangserver.core.exception.StatusCode

enum class MemberStatusCode(
    override val status: Int,
    override val message: String
): StatusCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_ALREADY_EXISTS(409, "Member already exists"),
    PASSWORD_NOT_MATCH(400, "Password doesn't match"),
}