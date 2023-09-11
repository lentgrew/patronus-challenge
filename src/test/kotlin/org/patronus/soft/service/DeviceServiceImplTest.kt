package org.patronus.soft.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.patronus.soft.dto.AssignDto
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.entity.DeviceEntity
import org.patronus.soft.entity.UserEntity
import org.patronus.soft.exception.DeviceException
import org.patronus.soft.repository.DeviceRepository
import org.patronus.soft.service.interfaces.UserService
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class DeviceServiceImplTest(
    @Mock
    private val deviceRepository: DeviceRepository,
    @Mock
    private val userService: UserService
) {
    @InjectMocks
    private lateinit var deviceServiceImpl: DeviceServiceImpl

    @Test
    fun `given deviceDto when called registerDevice then returned DeviceDto and save device`() {
        val deviceDto = DeviceDto(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        )
        Mockito.`when`(deviceRepository.save(any())).thenReturn(
            DeviceEntity(
                deviceDto.uuid,
                deviceDto.serialNumber,
                deviceDto.phoneNumber,
                deviceDto.model
            )
        )
        val result = deviceServiceImpl.registerDevice(deviceDto)

        verify(deviceRepository).save(any())
        assertEquals(deviceDto.uuid, result.uuid)
        assertEquals(deviceDto.serialNumber, result.serialNumber)
        assertEquals(deviceDto.phoneNumber, result.phoneNumber)
        assertEquals(deviceDto.model, result.model)
    }

    @Test
    fun `given deviceDto when called registerDevice then returned throw`() {
        val deviceDto = DeviceDto(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        )
        whenever(deviceRepository.countByUuid(any())).thenReturn(1L)

        assertThrows(DeviceException::class.java) { deviceServiceImpl.registerDevice(deviceDto) }
    }

    @Test
    fun `given deviceUuid, userUuid when called assignUser then called saving device`() {
        val assignDto = AssignDto(
            UUID.randomUUID()
        )

        whenever(deviceRepository.findFirstByUuid(any())).thenReturn(
            DeviceEntity(
                UUID.randomUUID(),
                "", "", ""
            )
        )

        whenever(userService.findUser(any())).thenReturn(
            UserEntity(
                UUID.randomUUID(), "firsName", "lastName", LocalDate.now(),
            )
        )

        deviceServiceImpl.assignUser(UUID.randomUUID(), assignDto)

        verify(deviceRepository).save(any())
    }

    @Test
    fun `given deviceUuid, userUuid when called assignUser then throw device NOT_FOUND`() {
        val assignDto = AssignDto(
            UUID.randomUUID()
        )

        assertThrows(DeviceException::class.java) { deviceServiceImpl.assignUser(UUID.randomUUID(), assignDto) }
    }

    @Test
    fun `given deviceUuid, userUuid when called assignUser then throw user NOT_FOUND`() {
        val assignDto = AssignDto(
            UUID.randomUUID()
        )
        whenever(deviceRepository.findFirstByUuid(any())).thenReturn(
            DeviceEntity(
                UUID.randomUUID(),
                "", "", ""
            )
        )

        assertThrows(DeviceException::class.java) { deviceServiceImpl.assignUser(UUID.randomUUID(), assignDto) }
    }
}