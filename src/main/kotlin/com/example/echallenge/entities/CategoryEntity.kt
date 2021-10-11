package com.example.echallenge.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Entity
data class CategoryEntity(
    var name: String?,
    var description: String?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    var productEntity: List<ProductEntity>?
) : BaseEntity(null) {
    constructor() : this(null, null, null)


}