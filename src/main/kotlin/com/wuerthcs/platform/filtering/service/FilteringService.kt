package com.wuerthcs.platform.filtering.service

import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.persistence.repository.FilteringRepository
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class FilteringService(
    private val repository: FilteringRepository,
    private val mapper: EntityMapper
) {


    //fun getAddress(uuid: UUID): FilterOption? {
    //    return this.mapper.map(this.repository.findAddressByUuid(uuid))
    //}
}