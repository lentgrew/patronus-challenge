package org.patronus.soft.service

import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.mapper.toDto
import org.patronus.soft.mapper.toEntity
import org.patronus.soft.exception.DeviceException
import org.patronus.soft.repository.DeviceRepository
import org.patronus.soft.service.interfaces.DeviceService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class DeviceServiceImpl(
    private val deviceRepository: DeviceRepository
) : DeviceService {
    override fun registerDevice(deviceDto: DeviceDto): DeviceDto {
        if(deviceRepository.countByUuid(deviceDto.uuid) > 0 )
            throw DeviceException("Have found the duplicate", HttpStatus.CONFLICT)

        return deviceRepository.save(deviceDto.toEntity()).toDto()
    }
}