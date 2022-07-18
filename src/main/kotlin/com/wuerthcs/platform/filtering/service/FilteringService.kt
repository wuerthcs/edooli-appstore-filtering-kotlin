package com.wuerthcs.platform.filtering.service

import com.wuerthcs.platform.filtering.domain.*
import com.wuerthcs.platform.filtering.persistence.repository.FilteringRepository
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class FilteringService(
        private val repository: FilteringRepository,
        private val mapper: EntityMapper
) {

    fun getAllFilterOptions(): List<FilterTypeResponse> {
        val response = listOf(
                getFilterTypeResponseById(1, "awkg"),
                getFilterTypeResponseById(2, "awkg"),
                getFilterTypeResponseById(3, "awkg")
        )
        return response;
    }

    private fun getFilterTypeResponseById(
            type: Int,
            branding: String
    ): FilterTypeResponse {
        val optionData = this.repository.findFilterOptionsByTypeAndBranding(type, branding);
        var response = FilterTypeResponse(type, "Trade", mutableListOf())
        if (optionData != null) {
            for (option in optionData) {
                response.filter_options.add(FilterOptionResponse(option.uuid, "Bla", getAddonIdentifiersForFilterOption(option.uuid)))
            }
        }
        return response
    }

    fun getAddonIdentifiersForFilterOption(uuid: UUID): MutableList<AddonIdentifierResponse>
    {
        var addonString: MutableList<AddonIdentifierResponse> = mutableListOf()

        val addonResponses =  this.repository.getFilterOptionAddonByFilterOptionUuid(uuid)
        if (addonResponses != null) {
            for (addon in addonResponses) {
                addonString.add(AddonIdentifierResponse(this.mapper.map2(addon).addonIdentifier))
            }
        }
        return addonString
    }
}