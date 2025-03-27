package pang.pangserver.infrastructure.domain.rds.member.entity

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import pang.pangserver.infrastructure.domain.rds.member.enumeration.MemberGender
import pang.pangserver.infrastructure.domain.rds.member.enumeration.MemberRole
import pang.pangserver.infrastructure.domain.rds.member.exception.PasswordNotMatchException
import pang.pangserver.infrastructure.domain.rds.support.entity.BasicEntity
import java.time.LocalDate
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
    var nickname: String? = null,

    @Column(columnDefinition = "text")
    var password: String,

    @Column(nullable = true, columnDefinition = "text")
    var profileImage: String? = null,

    @Enumerated(EnumType.STRING)
    val role: MemberRole,

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    var gender: MemberGender,

    var birthday: LocalDate,

    var isAlarm: Boolean? = false,
): BasicEntity() {
    fun updateInfo(nickname: String?, gender: MemberGender?, birthday: LocalDate?, isAlarm: Boolean?) {
        nickname?.let { this.nickname = it }
        gender?.let { this.gender = it }
        birthday?.let { this.birthday = it }
        isAlarm?.let { this.isAlarm = it }
    }
}