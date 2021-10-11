package com.example.echallenge.entities

import javax.persistence.*

@MappedSuperclass
open class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long?
) {
    constructor() : this(null)


}