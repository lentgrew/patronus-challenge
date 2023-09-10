package org.patronus.soft.exception

import org.springframework.http.HttpStatus

class DeviceException(
    message: String,
    val httpStatus: HttpStatus
) : RuntimeException(message)