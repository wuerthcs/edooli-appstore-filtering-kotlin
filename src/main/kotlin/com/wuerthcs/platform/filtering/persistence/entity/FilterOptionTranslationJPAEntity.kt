package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_option_translations")
class FilterOptionTranslationJPAEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    open val uuid: UUID = UUID.randomUUID(),

    @Column(name = "filter_option_uuid")
    open val filterOptionUuid: UUID,

    @Column(name = "language")
    open val language: String,

    @Column(name = "name")
    open val name: String,

    ) {


}