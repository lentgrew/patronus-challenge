package org.patronus.soft.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.patronus.soft.dto.UserDto
import org.patronus.soft.service.interfaces.UserService
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class UserControllerTest(
    @Mock
    private val userService: UserService
) {
    @InjectMocks
    private lateinit var userController: UserController

    @Test
    fun `given userDto when createUser was called then called userService`() {
        val userDto = UserDto(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now()
        )
        whenever(userService.createUser(any())).thenReturn(userDto)

        val response = userController.createUser(userDto)
        assertEquals(userDto, response)
    }

    @Test
    fun `given nothing when getUsers was called then called userService`() {
        userController.getUsers()
        verify(userService).getUsers()
    }
}