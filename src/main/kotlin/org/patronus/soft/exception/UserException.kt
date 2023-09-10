package org.patronus.soft.exception

import org.springframework.http.HttpStatus

class UserException(
    message: String,
    val httpStatus: HttpStatus
) : RuntimeException(message)