package org.patronus.soft.service.interfaces

import org.patronus.soft.dto.DeviceDto

interface DeviceService {
    fun registerDevice(deviceDto: DeviceDto): DeviceDto
}