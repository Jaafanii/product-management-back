package org.sid.echallenge.services

import org.sid.echallenge.dto.ProductDto
import org.sid.echallenge.entities.ProductEntity
import org.sid.echallenge.forms.ProductForm

interface ProductService : CrudService<ProductForm, ProductDto, ProductEntity> {
}