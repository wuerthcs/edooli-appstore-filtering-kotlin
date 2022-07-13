package com.wuerthcs.platform.filtering.controller

import com.wuerthcs.platform.filtering.domain.*
import com.wuerthcs.platform.filtering.service.FilteringService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class FilteringController(
    val service: FilteringService
) {
    @GetMapping("/get-filter-options", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(value = HttpStatus.OK)
    fun getFilterOptions(
        @RequestParam("branding", required = false) branding: String?,
        @RequestParam("language", required = false) language: String?,
        @RequestParam("addonIdentifiers", required = false) addonIdentifiers: Array<String>?,
        @RequestParam("filterOptionsUUids", required = false) filterOptionUuids: Array<UUID>?
    ): ResponseEntity<Array<FilterTypeResponse>> {

        //Hardcoded test response
        val response = arrayOf(
            FilterTypeResponse(1, "Application field", arrayOf(
                FilterOptionResponse(UUID.randomUUID(), "Bauhandwerk", arrayOf(
                    AddonIdentifierResponse("com.edooli.icvoicing"),
                    AddonIdentifierResponse("com.edooli.gaeb")
                ))
            )),
            FilterTypeResponse(2, "Keyword", arrayOf(
                FilterOptionResponse(UUID.randomUUID(), "Elektro", arrayOf(
                    AddonIdentifierResponse("com.edooli.datanorm"),
                    AddonIdentifierResponse("com.edooli.ids")
                ))
            )),
            FilterTypeResponse(3, "Trade", arrayOf(
                FilterOptionResponse(UUID.randomUUID(), "Bauhandwerk", arrayOf(
                    AddonIdentifierResponse("com.edooli.invoicing"),
                    AddonIdentifierResponse("com.edooli.gaeb")
                ))
            ))
        )
        val test = ResponseEntity.ok(response)
        return test

    }
}