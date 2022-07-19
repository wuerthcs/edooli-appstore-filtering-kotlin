package com.wuerthcs.platform.filtering.domain

import java.util.*

data class FilterOptionTranslation(
    val uuid: String,
    val filterOptionUuid: String,
    val language: String,
    val name: String
)
