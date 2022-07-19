package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_options_addons")
class FilterOptionAddonJPAEntity(
    @Id
    @Column(name = "uuid")
    open val uuid: String,

    @Column(name = "filter_option_uuid")
    open val filterOptionUuid: String,

    @Column(name = "addon_identifier")
    open val addonIdentifier: String,
) {

}