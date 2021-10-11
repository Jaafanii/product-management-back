package com.example.echallenge.services

import com.example.echallenge.dto.ProductDto
import com.example.echallenge.entities.ProductEntity
import com.example.echallenge.forms.ProductForm

interface ProductService : CrudService<ProductForm, ProductDto, ProductEntity> {
}