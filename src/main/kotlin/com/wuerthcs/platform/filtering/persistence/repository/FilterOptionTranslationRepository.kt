package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionTranslationJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.Column

interface FilterOptionTranslationRepository : JpaRepository<FilterOptionTranslationJPAEntity, UUID> {
    fun getFilterOptionTranslationByLanguageAndFilterOptionUuid(language: String, uuid: String) : List<FilterOptionTranslationJPAEntity>?
}