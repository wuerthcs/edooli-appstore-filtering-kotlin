package com.wuerthcs.platform.filtering.controller

import com.wuerthcs.platform.filtering.domain.*
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionAddonRepository
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionRepository
import com.wuerthcs.platform.filtering.persistence.repository.FilterOptionTranslationRepository
import com.wuerthcs.platform.filtering.service.FilteringService
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class FilteringController(
        val service: FilteringService,
        val filterOptionRepository: FilterOptionRepository,
        val filterOptionAddonRepository: FilterOptionAddonRepository,
        val filterOptionTranslationRepository: FilterOptionTranslationRepository,
        val mapper: EntityMapper
) {
    @GetMapping("/get-filter-options", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(value = HttpStatus.OK)

    fun getFilterOptions(
        @RequestParam("branding", required = false) branding: String?,
        @RequestParam("language", required = false) language: String?,
        @RequestParam("addonIdentifiers", required = false) addonIdentifiers: List<String>?,
        @RequestParam("filterOptionsUUids", required = false) filterOptionUuids: List<UUID>?
    ): ResponseEntity<List<FilterTypeResponse>> {

        val response = FilteringService(filterOptionRepository, filterOptionAddonRepository, filterOptionTranslationRepository, mapper).getAllFilterOptions();
        return ResponseEntity.ok(response)

    }
}