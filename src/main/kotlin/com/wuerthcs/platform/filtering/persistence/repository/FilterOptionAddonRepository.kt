package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FilterOptionAddonRepository : JpaRepository<FilterOptionAddonJPAEntity, String> {

    fun findFilterOptionsAddonsByFilterOptionUuid(uuid: String): MutableList<FilterOptionAddonJPAEntity>?

}