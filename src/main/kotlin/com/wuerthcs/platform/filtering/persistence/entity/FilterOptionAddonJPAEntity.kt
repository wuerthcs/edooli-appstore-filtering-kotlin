package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_options_addons")
class FilterOptionAddonJPAEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    open val uuid: UUID = UUID.randomUUID(),

    @Column(name = "filter_option_uuid")
    open val filterOptionUuid: UUID,

    @Column(name = "addon_identifier")
    open val addonIdentifier: String,
) {

}