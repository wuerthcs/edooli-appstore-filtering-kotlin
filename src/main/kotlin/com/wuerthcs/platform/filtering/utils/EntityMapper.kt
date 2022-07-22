package com.wuerthcs.platform.filtering.utils

import com.wuerthcs.platform.filtering.domain.FilterOptionAddon
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import org.springframework.stereotype.Component

@Component
class EntityMapper {
    fun mapFilterOptionAddon(entity: FilterOptionAddonJPAEntity) : FilterOptionAddon {
        return FilterOptionAddon(
                uuid = entity.uuid,
                filterOptionUuid = entity.filterOptionUuid,
                addonIdentifier = entity.addonIdentifier
        )
    }
}