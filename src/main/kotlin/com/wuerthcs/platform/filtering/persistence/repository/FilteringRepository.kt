package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.domain.AddonIdentifierResponse
import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface FilteringRepository :JpaRepository<FilterOptionJPAEntity, UUID> {
    //fun findAddressByUuid(uuid: UUID): FilterOptionJPAEntity?
    fun findFilterOptionsByTypeAndBranding(type: Int, branding: String): List<FilterOptionJPAEntity>?

    @Query(
            value = "SELECT * FROM filter_options_addons u WHERE u.filter_option_uuid = ?1",
            nativeQuery = true)
    fun getFilterOptionAddonByFilterOptionUuid(uuid: UUID): MutableList<FilterOptionAddonJPAEntity>?
}