package org.patronus.soft.mapper

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.patronus.soft.entity.DeviceEntity
import org.patronus.soft.entity.UserEntity
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserEntityMapperKtTest {
    @Test
    fun checkUserEntityToDto() {
        val userEntity = UserEntity(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now(),
            "address"
        )
        val userDto = userEntity.toDto()

        assertEquals(userDto.firstName, userEntity.firstName)
        assertEquals(userDto.lastName, userEntity.lastName)
        assertEquals(userDto.birthday, userEntity.birthday)
        assertEquals(userDto.address, userEntity.address)
    }

    @Test
    fun checkUserEntityToDetailsDto() {
        val deviceEntities = listOf(DeviceEntity(
            UUID.randomUUID(),
            "serialNumber",
            "phoneNumber",
            "model"
        ))
        val deviceDtoList = deviceEntities.map { it.toDto() }
        val userEntity = UserEntity(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now(),
            "address",
            deviceEntity = deviceEntities
        )
        val userDto = userEntity.toDetailsDto()

        assertEquals(userDto.firstName, userEntity.firstName)
        assertEquals(userDto.lastName, userEntity.lastName)
        assertEquals(userDto.birthday, userEntity.birthday)
        assertEquals(userDto.address, userEntity.address)
        assertEquals(userDto.devices, deviceDtoList)
    }
}
