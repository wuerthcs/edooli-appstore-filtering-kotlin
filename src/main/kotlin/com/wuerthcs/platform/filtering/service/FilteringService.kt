package com.wuerthcs.platform.filtering.service

import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonIdentifierJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionTranslationJPAEntity
import com.wuerthcs.platform.filtering.persistence.repository.FilteringRepository
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class FilteringService(
    private val repository: FilteringRepository,
    private val mapper: EntityMapper
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun all() {
        logger.info("all data ${this.repository.findAll()}")
    }


    //fun getAddress(uuid: UUID): FilterOption? {
    //    return this.mapper.map(this.repository.findAddressByUuid(uuid))
    //}
}