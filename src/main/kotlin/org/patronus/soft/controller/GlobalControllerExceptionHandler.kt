package org.patronus.soft.controller

import org.patronus.soft.dto.ApiErrorResponseDto
import org.patronus.soft.exception.DeviceException
import org.patronus.soft.exception.UserException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime


@ControllerAdvice
class GlobalControllerExceptionHandler {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(UserException::class)
    fun handleConflict(exception: UserException): ResponseEntity<ApiErrorResponseDto> {
        logger.error("UserException throw with cause: {}", exception.message)
        return ResponseEntity.status(exception.httpStatus)
            .body(
                ApiErrorResponseDto(
                    timestamp = LocalDateTime.now(),
                    message = exception.message,
                    status = exception.httpStatus
                )
            )
    }

    @ExceptionHandler(DeviceException::class)
    fun handleConflict(exception: DeviceException): ResponseEntity<ApiErrorResponseDto> {
        logger.error("DeviceException throw with cause: {}", exception.message)
        return ResponseEntity.status(exception.httpStatus)
            .body(
                ApiErrorResponseDto(
                    timestamp = LocalDateTime.now(),
                    message = exception.message,
                    status = exception.httpStatus
                )
            )
    }
}