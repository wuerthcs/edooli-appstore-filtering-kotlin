package com.wuerthcs.platform.filtering.domain

import java.util.UUID

data class FilterOptionAddon(
    val uuid: String,
    val filterOptionUuid: String,
    val addonIdentifier: String
)
