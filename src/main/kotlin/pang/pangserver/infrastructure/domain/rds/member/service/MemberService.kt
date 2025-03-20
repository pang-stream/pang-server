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
        require(memberRepository.findByEmail(email) == null && memberRepository.findByUsername(username) == null) {
            throw MemberAlreadyExistsException()
        }
    }

    fun findByUsername(username: String): MemberEntity? {
        return memberRepository.findByUsername(username)
    }

    fun save(member: MemberEntity)
        = memberRepository.save(member)

    fun findByEmail(email: String): MemberEntity {
        return memberRepository.findByEmail(email) ?: throw MemberNotFoundException()
    }
}