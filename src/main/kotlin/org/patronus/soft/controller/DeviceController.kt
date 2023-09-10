package org.patronus.soft.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.patronus.soft.dto.ApiErrorResponseDto
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.service.DeviceServiceImpl
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/devices")
class DeviceController(
    private val deviceService: DeviceServiceImpl
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Operation(summary = "Register the device")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = DeviceDto::class))]
        ), ApiResponse(
            responseCode = "400", description = "Bad Request", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = ApiErrorResponseDto::class)
            )]
        ), ApiResponse(
            responseCode = "500", description = "Internal Server Error", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = ApiErrorResponseDto::class)
            )]
        )]
    )
    @PostMapping
    fun registerDevice(@RequestBody deviceDto: DeviceDto): DeviceDto {
        logger.info("RegisterDevice: $deviceDto")
        return deviceService.registerDevice(deviceDto)
    }
}