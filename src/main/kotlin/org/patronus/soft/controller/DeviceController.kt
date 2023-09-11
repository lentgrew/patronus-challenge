package org.patronus.soft.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.patronus.soft.dto.ApiErrorResponseDto
import org.patronus.soft.dto.AssignDto
import org.patronus.soft.dto.DeviceDto
import org.patronus.soft.service.interfaces.DeviceService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/v1/devices")
class DeviceController(
    private val deviceService: DeviceService
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

    @Operation(summary = "Assign the user for the device")
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
            responseCode = "404", description = "Device or user not found", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = ApiErrorResponseDto::class)
            )]
        ),ApiResponse(
            responseCode = "500", description = "Internal Server Error", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = ApiErrorResponseDto::class)
            )]
        )]
    )
    @PostMapping("/{deviceUuid}")
    fun assignUser(@PathVariable deviceUuid:UUID, @RequestBody assignDto: AssignDto) {
        logger.info("Assign the user: ${assignDto.userId} for the device: $deviceUuid")
        return deviceService.assignUser(deviceUuid, assignDto)
    }
}