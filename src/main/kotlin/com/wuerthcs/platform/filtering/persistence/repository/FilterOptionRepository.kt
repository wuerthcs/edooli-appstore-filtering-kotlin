package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface FilterOptionRepository :JpaRepository<FilterOptionJPAEntity, UUID> {

    fun findFilterOptionsByTypeAndBranding(type: Int, branding: String): List<FilterOptionJPAEntity>?
}
