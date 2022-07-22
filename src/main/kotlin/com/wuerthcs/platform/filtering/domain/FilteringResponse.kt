package com.wuerthcs.platform.filtering.domain

import java.util.UUID

class FilteringResponse {

}
class FilterTypeResponse(
        val id: Int,
        val type_name: String,
        var filter_options: MutableList<FilterOptionResponse>

) {}

class FilterOptionResponse(
        val id: String,
        val filter_option_name: String?,
        var addon_identifiers: MutableList<AddonIdentifierResponse>
){}

class AddonIdentifierResponse(
    val id: String
) {}