package pang.pangserver.infrastructure.domain.rds.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pang.pangserver.infrastructure.domain.rds.member.entity.MemberEntity
import java.util.*

@Repository
interface MemberRepository: JpaRepository<MemberEntity, UUID> {
    fun findByEmail(email: String): MemberEntity?
    fun findByUsername(username: String): MemberEntity?
    fun findByEmailOrUsername(email: String, username: String): List<MemberEntity>
}