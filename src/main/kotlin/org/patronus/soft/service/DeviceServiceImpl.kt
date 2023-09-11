package org.patronus.soft.service

import org.patronus.soft.dto.AssignDto
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.mapper.toDto
import org.patronus.soft.mapper.toEntity
import org.patronus.soft.exception.DeviceException
import org.patronus.soft.repository.DeviceRepository
import org.patronus.soft.service.interfaces.DeviceService
import org.patronus.soft.service.interfaces.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeviceServiceImpl(
    private val deviceRepository: DeviceRepository,
    private val userService: UserService
) : DeviceService {
    override fun registerDevice(deviceDto: DeviceDto): DeviceDto {
        if(deviceRepository.countByUuid(deviceDto.uuid) > 0 )
            throw DeviceException("Have found the duplicate", HttpStatus.CONFLICT)

        return deviceRepository.save(deviceDto.toEntity()).toDto()
    }

    @Transactional
    override fun assignUser(deviceUuid: UUID, assignDto: AssignDto) {
        val device = deviceRepository.findFirstByUuid(deviceUuid) ?:
            throw DeviceException("The Device not found", HttpStatus.NOT_FOUND)

        val user = userService.findUser(assignDto.userId) ?:
            throw DeviceException("The User not found", HttpStatus.NOT_FOUND)

        device.user?.let {
            throw DeviceException("The User was assigned", HttpStatus.CONFLICT)
        }

        device.user = user
        deviceRepository.save(device)
    }
}