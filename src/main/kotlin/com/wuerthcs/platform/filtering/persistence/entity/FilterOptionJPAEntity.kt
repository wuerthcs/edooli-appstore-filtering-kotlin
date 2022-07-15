package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "filter_option")
class FilterOptionJPAEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", length = 16)
    val uuid: UUID = UUID.randomUUID(),

    @Column(name = "type")
    val type: Int,

    @Column(name = "branding")
    val branding: String,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "option")
    val options : List<FilterOptionAddonJPAEntity>,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name ="option_translation",
        joinColumns = [
            JoinColumn(name = "option_uuid")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "translation_uuid")
        ]
    )
    val translation : Set<FilterOptionTranslationJPAEntity>

) {

    override fun toString(): String {
        return "FilterOptionJPAEntity(uuid=$uuid, type=$type, branding='$branding', options=$options, translation=$translation)"
    }
}
