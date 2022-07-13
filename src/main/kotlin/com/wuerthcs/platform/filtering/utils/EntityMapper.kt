package com.wuerthcs.platform.filtering.utils

import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import org.springframework.stereotype.Component

@Component
class EntityMapper {
    //fun map(entity: AddressJPAEntity) : Address {
    //    return when (entity) {
    //        else ->
   //     }
    //}
    /*fun map(filterOption: FilterOption) : FilterOptionJPAEntity {
        return FilterOptionJPAEntity(
                uuid = filterOption.uuid,
                placeId = filterOption.placeId,
                street = filterOption.street,
                number = filterOption.number,
                addressAdjustments = filterOption.addressAdjustments,
                zip = filterOption.zip,
                city = filterOption.city,
                countryCode = filterOption.countryCode,
                additionalInformation = filterOption.additionalInformation
        )
    }
    fun map (entity: FilterOptionJPAEntity?) : FilterOption? {
        if (entity === null) {
            return null
        }
        else {
            return FilterOption(
                    uuid = entity.uuid,
                    placeId = entity.placeId,
                    street = entity.street,
                    number = entity.number,
                    addressAdjustments = entity.addressAdjustments,
                    zip = entity.zip,
                    city = entity.city,
                    countryCode = entity.countryCode,
                    additionalInformation = entity.additionalInformation
            )
        }
    }*/
}