package com.wuerthcs.platform.filtering.domain

import java.util.UUID

data class FilterOptionAddon(
    val uuid: UUID,
    val filterOptionUuid: UUID,
    val addonIdentifier: String
)
