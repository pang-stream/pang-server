package pang.pangserver.infrastructure.domain.rds.member.service

import org.springframework.stereotype.Service
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.rds.member.exception.MemberAlreadyExistsException
import pang.pangserver.infrastructure.domain.rds.member.exception.MemberNotFoundException
import pang.pangserver.infrastructure.domain.rds.member.repository.MemberRepository

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun validateMemberDuplicated(username: String, email: String) {
        if(memberRepository.findByEmailOrUsername(email, username).isNotEmpty()) throw MemberAlreadyExistsException()
    }

    fun save(member: MemberEntity)
        = memberRepository.save(member)

    fun findByEmail(email: String): MemberEntity {
        return memberRepository.findByEmail(email) ?: throw MemberNotFoundException()
    }
}