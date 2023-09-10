package org.patronus.soft.service

import org.patronus.soft.dto.UserDetailsDto
import org.patronus.soft.dto.UserDto
import org.patronus.soft.mapper.toDto
import org.patronus.soft.mapper.toEntity
import org.patronus.soft.exception.UserException
import org.patronus.soft.mapper.toDetailsDto
import org.patronus.soft.repository.UserRepository
import org.patronus.soft.service.interfaces.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun createUser(userDto: UserDto): UserDto {
        if (userRepository.countByFirstNameAndLastNameAndBirthday(userDto.firstName, userDto.lastName, userDto.birthday) > 0)
            throw UserException("Have found the duplicate", HttpStatus.CONFLICT)

        return userRepository.save(
            userDto.toEntity()
        ).toDto()
    }

    override fun getUsers(): List<UserDetailsDto> {
        return userRepository.findAll().map { it.toDetailsDto() }
    }
}