package org.patronus.soft.service.interfaces

import org.patronus.soft.dto.UserDetailsDto
import org.patronus.soft.dto.UserDto

interface UserService {
    fun createUser(userDto: UserDto): UserDto
    fun getUsers(): List<UserDetailsDto>
}