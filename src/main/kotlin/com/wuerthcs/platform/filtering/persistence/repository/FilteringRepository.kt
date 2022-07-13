package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FilteringRepository :JpaRepository<FilterOptionJPAEntity, UUID> {
    //fun findAddressByUuid(uuid: UUID): FilterOptionJPAEntity?
}