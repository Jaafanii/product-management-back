package com.example.echallenge.dto

import java.math.BigDecimal


data class ProductDto(
    var id: Long,
    var name: String,
    var quantity: Int,
    var price: BigDecimal,
    var category: CategoryDto,
)