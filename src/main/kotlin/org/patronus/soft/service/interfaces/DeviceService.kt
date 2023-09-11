package org.patronus.soft.service.interfaces

import org.patronus.soft.dto.AssignDto
import org.patronus.soft.dto.DeviceDto
import java.util.*

interface DeviceService {
    fun registerDevice(deviceDto: DeviceDto): DeviceDto
    fun assignUser(deviceUuid: UUID, assignDto: AssignDto)
}