package org.patronus.soft.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.patronus.soft.dto.AssignDto
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.service.interfaces.DeviceService
import java.util.UUID

@ExtendWith(MockitoExtension::class)
internal class DeviceControllerTest(
    @Mock
    private val deviceService: DeviceService
) {
    @InjectMocks
    private lateinit var deviceController: DeviceController

    @Test
    fun `given deviceDto when registerDevice was called then called deviceService`() {
        val deviceDto = DeviceDto(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        )
        whenever(deviceService.registerDevice(any())).thenReturn(deviceDto)

        val response = deviceController.registerDevice(deviceDto)
        assertEquals(deviceDto, response)
    }

    @Test
    fun `given assignUser when assignUser was called then called deviceService`() {
        val deviceUuid = UUID.randomUUID()
        val assignDto = AssignDto(
            UUID.randomUUID(),
        )

        deviceController.assignUser(deviceUuid, assignDto)
        verify(deviceService).assignUser(deviceUuid, assignDto)
    }
}