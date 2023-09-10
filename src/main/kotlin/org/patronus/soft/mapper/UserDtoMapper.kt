package org.patronus.soft.mapper

import org.patronus.soft.dto.UserDto
import org.patronus.soft.entity.UserEntity

fun UserDto.toEntity() : UserEntity = UserEntity(
    firstName = firstName,
    lastName = lastName,
    birthday = birthday,
    address = address
)