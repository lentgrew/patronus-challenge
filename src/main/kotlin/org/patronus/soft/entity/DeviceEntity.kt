package org.patronus.soft.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "device")
data class DeviceEntity(
    @Id
    var uuid: UUID,
    val serialNumber: String,
    val phoneNumber: String,
    val model: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    var user: UserEntity? = null
) : BaseEntity()