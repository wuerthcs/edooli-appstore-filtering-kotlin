package com.wuerthcs.platform.filtering.persistence.entity

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "filter_options")
class FilterOptionJPAEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    open val uuid: UUID = UUID.randomUUID(),

    @Column(name = "type")
    open val type: Int,

    @Column(name = "branding")
    open val branding: String,
)
