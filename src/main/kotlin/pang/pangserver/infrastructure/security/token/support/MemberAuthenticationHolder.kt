package pang.pangserver.infrastructure.security.token.support

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberDetails
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity

@Component
object MemberAuthenticationHolder {
    fun current(): MemberEntity {
        return (SecurityContextHolder.getContext().authentication.principal as MemberDetails).member
    }
}