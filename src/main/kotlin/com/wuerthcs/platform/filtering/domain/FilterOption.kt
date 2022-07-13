package com.wuerthcs.platform.filtering.domain

import java.util.UUID

data class FilterOption(
        val uuid: UUID,
        val type: FilterType,
        val branding: String,
        val order: Int?
) {

}
