package org.patronus.soft.repository

import org.patronus.soft.entity.UserEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*


@Repository
interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun findFirstById(userId : UUID): UserEntity?
    fun countByFirstNameAndLastNameAndBirthday(firstName: String, lastName: String, birthday: LocalDate): Long

    @Query("select u from UserEntity u LEFT JOIN FETCH u.deviceEntity")
    @EntityGraph(attributePaths = ["deviceEntity"])
    override fun findAll(): List<UserEntity>
}