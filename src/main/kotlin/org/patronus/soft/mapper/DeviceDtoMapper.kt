package org.patronus.soft.mapper

import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.entity.DeviceEntity

fun DeviceDto.toEntity() : DeviceEntity = DeviceEntity(
    uuid = uuid,
    serialNumber = serialNumber,
    model = model,
    phoneNumber = phoneNumber
)

fun DeviceEntity.toDto(): DeviceDto = DeviceDto(
    uuid = uuid,
    serialNumber = serialNumber,
    model = model,
    phoneNumber = phoneNumber
)