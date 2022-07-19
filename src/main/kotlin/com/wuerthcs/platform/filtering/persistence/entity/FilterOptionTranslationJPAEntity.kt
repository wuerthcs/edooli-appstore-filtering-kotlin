package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "filter_option_translations")
class FilterOptionTranslationJPAEntity(
    @Id
    @Column(name = "uuid")
    open val uuid: String,

    @Column(name = "filter_option_uuid")
    open val filterOptionUuid: String,

    @Column(name = "language")
    open val language: String,

    @Column(name = "name")
    open val name: String,

    ) {


}