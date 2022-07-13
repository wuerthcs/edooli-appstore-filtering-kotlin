package com.wuerthcs.platform.filtering.domain

import java.util.UUID

class FilteringResponse {

}
class FilterTypeResponse(
    val id: Int,
    val type_name: String,
    val filter_options: Array<FilterOptionResponse>

) {}

class FilterOptionResponse(
    val id: UUID,
    val filter_option_name: String,
    val addon_identifiers: Array<AddonIdentifierResponse>
){}

class AddonIdentifierResponse(
    val id: String
) {}