package org.patronus.soft.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime


data class ApiErrorResponseDto(val timestamp: LocalDateTime, val message: String?, val status: HttpStatus)