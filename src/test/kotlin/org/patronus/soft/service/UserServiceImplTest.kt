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
import org.patronus.soft.dto.UserDto
import org.patronus.soft.entity.UserEntity
import org.patronus.soft.exception.UserException
import org.patronus.soft.repository.UserRepository
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceImplTest(
    @Mock
    private val userRepository: UserRepository
) {
    @InjectMocks
    private lateinit var userServiceImpl: UserServiceImpl

    @Test
    fun `given userDto when called createUser then returned UserDto and save user`() {
        val userDto = UserDto(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now()
        )
        Mockito.`when`(userRepository.save(any())).thenReturn(
            UserEntity(
                UUID.randomUUID(),
                userDto.firstName,
                userDto.lastName,
                userDto.birthday
            )
        )
        val result = userServiceImpl.createUser(userDto = userDto)

        verify(userRepository).save(any())
        assertEquals(userDto.firstName, result.firstName)
        assertEquals(userDto.lastName, result.lastName)
        assertEquals(userDto.birthday, result.birthday)
    }

    @Test
    fun `given userDto when called createUser then returned throw`() {
        val userDto = UserDto(
            UUID.randomUUID(),
            "firstName",
            "lastName",
            LocalDate.now()
        )
        whenever(userRepository.countByFirstNameAndLastNameAndBirthday(any(), any(), any())).thenReturn(1L)

        assertThrows(UserException::class.java) { userServiceImpl.createUser(userDto = userDto) }
    }

    @Test
    fun `given nothing when called getUsers then returned list of users`() {
        userServiceImpl.getUsers()

        verify(userRepository).findAll()
    }

    @Test
    fun `given User UUId when called findUser then returned UserEntity`() {
        userServiceImpl.findUser(UUID.randomUUID())

        verify(userRepository).findFirstById(any())
    }
}