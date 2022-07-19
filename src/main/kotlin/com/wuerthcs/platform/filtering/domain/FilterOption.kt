package com.wuerthcs.platform.filtering.domain

import java.util.UUID

data class FilterOption(
        val uuid: String,
        val type: Int,
        val branding: String,
        val sortOrder: Int?
) {

}
