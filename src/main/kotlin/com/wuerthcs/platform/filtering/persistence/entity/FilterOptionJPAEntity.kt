package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "filter_options")
class FilterOptionJPAEntity (
    @Id
    @Column(name = "uuid")
    open val uuid: String,

    @Column(name = "type")
    open val type: Int,

    @Column(name = "branding")
    open val branding: String,

    @Column(name = "sort_order")
    open val sortOrder: Int
)
