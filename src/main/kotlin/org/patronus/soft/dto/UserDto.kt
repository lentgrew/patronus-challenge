package org.patronus.soft.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.util.*

data class UserDto(
    val id: UUID?,
    val firstName: String,
    val lastName: String,
    @JsonFormat(pattern="yyyy-MM-dd")
    val birthday: LocalDate,
    val address: String? = null
)