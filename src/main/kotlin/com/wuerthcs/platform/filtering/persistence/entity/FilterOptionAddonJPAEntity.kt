package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_option_addon")
class FilterOptionAddonJPAEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", length = 16)
    val uuid: UUID = UUID.randomUUID(),

    @Column(name = "id", length = 16)
    val id: UUID,

    @Column(name = "sort_order")
    val order: Int,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "addon_identifier",
        joinColumns = [
            JoinColumn(name = "addon_uuid")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "identifier_uuid")
        ]
    )
    val addonIdentifier: Set<FilterOptionAddonIdentifierJPAEntity>,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "addon_translation",
        joinColumns = [
            JoinColumn(name = "addon_uuid")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "translation_uuid")
        ]
    )
    val filterOptionName: Set<FilterOptionTranslationJPAEntity>


) {

    override fun toString(): String {
        return "FilterOptionAddonJPAEntity(uuid=$uuid, id=$id, filterOptionName='$filterOptionName', addonIdentifier=$addonIdentifier)"
    }
}