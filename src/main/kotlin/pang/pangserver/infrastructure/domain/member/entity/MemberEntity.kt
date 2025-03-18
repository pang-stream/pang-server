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

    @Column(nullable = true)
    val nickname: String? = null,

    val email: String,

    @Column(columnDefinition = "text")
    val password: String,

    @Column(nullable = true, columnDefinition = "text")
    val profileImage: String? = null,

    val role: MemberRole,

    val isAlarm: Boolean? = false,
): BasicEntity()