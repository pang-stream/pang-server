package pang.pangserver.infrastructure.domain.member.service

import org.springframework.stereotype.Service
import pang.pangserver.infrastructure.domain.member.entity.MemberEntity
import pang.pangserver.infrastructure.domain.member.repository.MemberRepository

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun save(member: MemberEntity)
        = memberRepository.save(member)
}