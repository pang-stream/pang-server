package pang.pangserver.infrastructure.domain.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import pang.pangserver.infrastructure.domain.member.entity.MemberEntity
import java.util.*

interface MemberRepository: JpaRepository<MemberEntity, UUID> {
    fun findByEmail(email: String): MemberEntity?
    fun findByUsername(username: String): MemberEntity?
}