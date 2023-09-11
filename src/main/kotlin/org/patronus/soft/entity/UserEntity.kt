package org.patronus.soft.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue
    @UuidGenerator
    val id: UUID? = null,
    val firstName: String,
    val lastName: String,
    val birthday: LocalDate,
    val address: String? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var deviceEntity: List<DeviceEntity>? = null
) : BaseEntity()