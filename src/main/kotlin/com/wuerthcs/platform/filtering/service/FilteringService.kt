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
    var cachedAddonList = AddonListResultCache.addonIdentifiers

    fun getAllFilterOptions(branding: String, language: String): List<FilterTypeResponse> {
        cachedAddonList.clear()
        return listOf(
                getFilterTypeResponseById(1, branding, language),
                getFilterTypeResponseById(2, branding, language),
                getFilterTypeResponseById(3, branding, language)
        )
    }

    fun getFilteredOptions(branding: String, language: String, filterOptionUuids: List<String>?, addonIdentifiers: List<String>?): List<FilterTypeResponse> {
        cachedAddonList.clear()
        if(addonIdentifiers!=null){
            for(identifier in addonIdentifiers){
                cachedAddonList.add(identifier)
            }
        }
        return listOf(
                getFilterTypeResponseById(1, branding, language, filterOptionUuids),
                getFilterTypeResponseById(2, branding, language, filterOptionUuids),
                getFilterTypeResponseById(3, branding, language, filterOptionUuids)
        )
    }

    private fun getFilterTypeResponseById(
            type: Int,
            branding: String,
            lang: String,
            optionUUIDs: List<String>? = null
    ): FilterTypeResponse {
        val optionData = this.filterOptionRepository.findFilterOptionsByTypeAndBranding(type, branding);
        var response = FilterTypeResponse(type, "Trade", mutableListOf())
        if (optionData != null) {
            for (option in optionData) {
                var filterTranslation = this.filterOptionTranslationRepository.findFilterOptionTranslationByLanguageAndFilterOptionUuid(lang, option.uuid)
                response.filter_options.add(FilterOptionResponse(
                        option.uuid,
                        filterTranslation?.name.toString(),
                        getAddonIdentifiersForFilterOption(option.uuid, optionUUIDs)
                ))
            }
        }
        return response
    }

    fun getAddonIdentifiersForFilterOption(uuid: String, optionUUIDs: List<String>?): MutableList<AddonIdentifierResponse> {
        var addonString: MutableList<AddonIdentifierResponse> = mutableListOf()

        val addonResponses = this.filterOptionAddonRepository.findFilterOptionsAddonsByFilterOptionUuid(uuid)
        if (addonResponses != null && (optionUUIDs==null || uuid in optionUUIDs)) {
            var results: MutableList<String> = mutableListOf()
            for (addon in addonResponses) {
                val identifier = this.mapper.map2(addon).addonIdentifier
                if (cachedAddonList.size == 0 || identifier in cachedAddonList) {
                    addonString.add(AddonIdentifierResponse(identifier))
                    results.add(identifier)
                }
            }
            if (cachedAddonList.size == 0) {
                for (item in results) {
                    cachedAddonList.add(item)
                }
            } else {
                for (cachedItem in cachedAddonList) {
                    if (cachedItem !in results) {
                        cachedAddonList.remove(cachedItem)
                    }
                }
            }
        }
        return addonString
    }

}

class AddonListResultCache{
    companion object{
        val addonIdentifiers = mutableListOf<String>()
    }
    var companion = Companion
}