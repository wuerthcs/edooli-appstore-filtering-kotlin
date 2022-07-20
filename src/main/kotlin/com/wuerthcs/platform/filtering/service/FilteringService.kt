package com.wuerthcs.platform.filtering.service

import com.wuerthcs.platform.filtering.domain.*
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionAddonRepository
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionRepository
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionTranslationRepository
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.springframework.stereotype.Service

@Service
class FilteringService(
        private val filterOptionRepository: FilterOptionRepository,
        private val filterOptionAddonRepository: FilterOptionAddonRepository,
        private val filterOptionTranslationRepository: FilterOptionTranslationRepository,
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
        val optionData = this.filterOptionRepository.findFilterOptionsByTypeAndBranding(type, branding);
        var response = FilterTypeResponse(type, "Trade", mutableListOf())
        if (optionData != null) {
            for (option in optionData) {
                var filterTranslation = this.filterOptionTranslationRepository.getFilterOptionTranslationByLanguageAndFilterOptionUuid("de", option.uuid)
                response.filter_options.add(FilterOptionResponse(
                        option.uuid,
                        filterTranslation?.get(0)?.name.toString(),
                        getAddonIdentifiersForFilterOption(option.uuid)
                ))
            }
        }
        return response
    }

    fun getAddonIdentifiersForFilterOption(uuid: String): MutableList<AddonIdentifierResponse>
    {
        var addonString: MutableList<AddonIdentifierResponse> = mutableListOf()

        val addonResponses =  this.filterOptionAddonRepository.findFilterOptionsAddonsByFilterOptionUuid(uuid)
        if (addonResponses != null) {
            for (addon in addonResponses) {
                addonString.add(AddonIdentifierResponse(this.mapper.map2(addon).addonIdentifier))
            }
        }
        return addonString
    }


}