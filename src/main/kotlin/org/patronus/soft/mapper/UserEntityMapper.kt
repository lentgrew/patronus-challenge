package org.patronus.soft.mapper

import org.patronus.soft.dto.UserDetailsDto
import org.patronus.soft.dto.UserDto
import org.patronus.soft.entity.UserEntity

fun UserEntity.toDto(): UserDto = UserDto(
    id = id,
    firstName = firstName,
    lastName = lastName,
    birthday = birthday,
    address = address
)

fun UserEntity.toDetailsDto(): UserDetailsDto = UserDetailsDto(
    id = id,
    firstName = firstName,
    lastName = lastName,
    birthday = birthday,
    address = address,
    devices = deviceEntity?.map { it.toDto() }
)