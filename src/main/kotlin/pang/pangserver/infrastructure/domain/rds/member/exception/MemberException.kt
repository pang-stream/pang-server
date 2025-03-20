package pang.pangserver.infrastructure.domain.rds.member.exception

import pang.pangserver.core.exception.BasicException

class MemberNotFoundException(): BasicException(MemberStatusCode.MEMBER_NOT_FOUND)
class PasswordNotMatchException(): BasicException(MemberStatusCode.PASSWORD_NOT_MATCH)
class MemberAlreadyExistsException(): BasicException(MemberStatusCode.MEMBER_ALREADY_EXISTS)