package org.patronus.soft.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class UserDetailsDto(
    val id: UUID?,
    val firstName: String,
    val lastName: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val birthday: Date,
    val address: String? = null,
    val devices: List<DeviceDto>? = null
)
