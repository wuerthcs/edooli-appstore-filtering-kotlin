package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_option_addon_identifier")
class FilterOptionAddonIdentifierJPAEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", length = 16)
    val uuid: UUID = UUID.randomUUID(),

    @Column(name = "identifier")
    val identifier: String
) {

    override fun toString(): String {
        return "FilterOptionAddonIdentifierJPAEntity(uuid=$uuid, identifier='$identifier')"
    }
}