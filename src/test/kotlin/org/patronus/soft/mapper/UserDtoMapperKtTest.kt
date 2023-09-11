package org.patronus.soft.mapper

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.patronus.soft.dto.UserDto
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserDtoMapperKtTest {
    @Test
    fun checkUserDtoToEntity() {
        val userDto = UserDto(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now(),
            "address"
        )
        val userEntity = userDto.toEntity()

        assertEquals(userDto.firstName, userEntity.firstName)
        assertEquals(userDto.lastName, userEntity.lastName)
        assertEquals(userDto.birthday, userEntity.birthday)
        assertEquals(userDto.address, userEntity.address)
    }
}