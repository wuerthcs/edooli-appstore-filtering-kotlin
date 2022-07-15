package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_option_translation")
class FilterOptionTranslationJPAEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", length = 16)
    val uuid: UUID = UUID.randomUUID(),

    @Column(name = "language")
    val language: String,

    @Column(name = "label")
    val label: String,

) {

    override fun toString(): String {
        return "FilterOptionTranslationJPAEntity(uuid=$uuid, language='$language', label='$label')"
    }
}