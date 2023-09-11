package org.patronus.soft.mapper

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.entity.DeviceEntity
import java.util.*

@ExtendWith(MockitoExtension::class)
class DeviceDtoMapperKtTest {
    @Test
    fun checkDeviceDtoToEntity() {
        val deviceDto = DeviceDto(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        )
        val deviceEntity = deviceDto.toEntity()

        assertEquals(deviceDto.uuid, deviceEntity.uuid)
        assertEquals(deviceDto.serialNumber, deviceEntity.serialNumber)
        assertEquals(deviceDto.phoneNumber, deviceEntity.phoneNumber)
        assertEquals(deviceDto.model, deviceEntity.model)
    }

    @Test
    fun checkDeviceEntityToDto() {
        val deviceEntity = DeviceEntity(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        )
        val deviceDto = deviceEntity.toDto()

        assertEquals(deviceDto.uuid, deviceEntity.uuid)
        assertEquals(deviceDto.serialNumber, deviceEntity.serialNumber)
        assertEquals(deviceDto.phoneNumber, deviceEntity.phoneNumber)
        assertEquals(deviceDto.model, deviceEntity.model)
    }
}