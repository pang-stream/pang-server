package pang.pangserver.infrastructure.domain.member.entity

import jakarta.persistence.*
import java.util.*

@Entity(name = "member")
class MemberEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    private val username: String,

    private val nickname: String? = null,

    private val email: String,

    @Column(columnDefinition = "text")
    private val password: String,

    @Column(columnDefinition = "text")
    private val profileImage: String? = null,
)