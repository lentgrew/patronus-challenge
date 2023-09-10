package org.patronus.soft.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.patronus.soft.dto.ApiErrorResponseDto
import org.patronus.soft.dto.UserDetailsDto
import org.patronus.soft.dto.UserDto
import org.patronus.soft.service.interfaces.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userService: UserService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Operation(summary = "Create the user")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = UserDto::class))]
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
    fun createUser(@RequestBody userDto: UserDto): UserDto {
        logger.info("CreateUser: $userDto")
        return userService.createUser(userDto)
    }

    @Operation(summary = "Get all users with devices")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = UserDetailsDto::class))]
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
    @GetMapping
    fun getUsers(): List<UserDetailsDto> = userService.getUsers()
}