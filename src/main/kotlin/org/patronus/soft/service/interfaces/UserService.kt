package org.patronus.soft.service.interfaces

import org.patronus.soft.dto.UserDetailsDto
import org.patronus.soft.dto.UserDto
import org.patronus.soft.entity.UserEntity
import java.util.*

interface UserService {
    fun createUser(userDto: UserDto): UserDto
    fun getUsers(): List<UserDetailsDto>
    fun findUser(userId: UUID): UserEntity?
}