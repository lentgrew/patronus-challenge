package org.patronus.soft.dto

import java.util.*

data class DeviceDto(
    val uuid: UUID,
    val serialNumber: String,
    val phoneNumber: String,
    val model: String
)
