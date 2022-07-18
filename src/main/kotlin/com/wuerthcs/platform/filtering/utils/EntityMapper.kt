package com.wuerthcs.platform.filtering.utils

import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.domain.FilterOptionAddon
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.stereotype.Component

@Component
class EntityMapper {
    fun map (entity: FilterOptionJPAEntity) : FilterOption {
        return FilterOption(
                uuid = entity.uuid,
                type = entity.type,
                branding = entity.branding,
                sortOrder = entity.sortOrder
        )
    }
    fun map2(entity: FilterOptionAddonJPAEntity) : FilterOptionAddon {
        return FilterOptionAddon(
                uuid = entity.uuid,
                filterOptionUuid = entity.filterOptionUuid,
                addonIdentifier = entity.addonIdentifier
        )
    }
}