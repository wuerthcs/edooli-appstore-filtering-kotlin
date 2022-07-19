package com.wuerthcs.platform.filtering.persistence.repository

import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionTranslationJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FilterOptionTranslationRepository : JpaRepository<FilterOptionTranslationJPAEntity, UUID> {
    fun getFilterOptionTranslationByLanguageAndUuid(language: String, uuid: String) :String?
}