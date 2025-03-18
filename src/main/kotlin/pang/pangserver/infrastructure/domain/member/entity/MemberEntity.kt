package pang.pangserver.infrastructure.domain.member.entity

import jakarta.persistence.*
import pang.pangserver.infrastructure.domain.member.enumeration.MemberRole
import pang.pangserver.infrastructure.domain.support.entity.BasicEntity
import java.util.*

@Entity(name = "member")
class MemberEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    val username: String,

    val nickname: String? = null,

    val email: String,

    @Column(columnDefinition = "text")
    val password: String,

    @Column(columnDefinition = "text")
    val profileImage: String? = null,

    val role: MemberRole? = null,
): BasicEntity()