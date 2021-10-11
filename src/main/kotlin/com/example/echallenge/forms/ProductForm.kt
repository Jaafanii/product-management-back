package com.example.echallenge.forms

import java.math.BigDecimal

class ProductForm(
    var name: String,
    var quantity: Int,
    var price: BigDecimal,
    var categoryId: Long
)