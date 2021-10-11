package org.sid.echallenge.entities

import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class ProductEntity(
    var name: String?,
    var quantity: Int?,
    var price: BigDecimal?,
    var creationDate: Date?,
    @JoinColumn(nullable = false)
    @ManyToOne
    var category: CategoryEntity?,
) : BaseEntity(null) {
    constructor() : this(null, null, null, Date(), null)


}