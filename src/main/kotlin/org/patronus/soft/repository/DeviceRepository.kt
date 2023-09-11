package org.patronus.soft.repository

import org.patronus.soft.entity.DeviceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DeviceRepository: JpaRepository<DeviceEntity, UUID>{
    fun countByUuid(uuid: UUID): Long
    fun findFirstByUuid(deviceUUID: UUID): DeviceEntity?
}