package pang.pangserver.infrastructure.domain.rds.member.entity

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import pang.pangserver.infrastructure.domain.rds.member.enumeration.MemberRole
import pang.pangserver.infrastructure.domain.rds.member.exception.PasswordNotMatchException
import pang.pangserver.infrastructure.domain.rds.support.entity.BasicEntity
import java.util.*

@Entity(name = "member")
class MemberEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = true)
    val nickname: String? = null,

    @Column(columnDefinition = "text")
    val password: String,

    @Column(nullable = true, columnDefinition = "text")
    val profileImage: String? = null,

    val role: MemberRole,

    val isAlarm: Boolean? = false,
): BasicEntity() {
}