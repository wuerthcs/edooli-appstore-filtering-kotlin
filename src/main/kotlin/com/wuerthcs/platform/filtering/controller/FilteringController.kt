package com.wuerthcs.platform.filtering.controller

import com.wuerthcs.platform.filtering.domain.*
import com.wuerthcs.platform.filtering.persistence.repository.FilteringRepository
import com.wuerthcs.platform.filtering.service.FilteringService
import com.wuerthcs.platform.filtering.utils.EntityMapper
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class FilteringController(
    val service: FilteringService,
    val repository: FilteringRepository,
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

        val response = FilteringService(repository, mapper).getAllFilterOptions();
        return ResponseEntity.ok(response)

    }
}