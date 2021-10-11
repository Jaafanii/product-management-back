package org.sid.echallenge.controllers

import io.swagger.annotations.Api
import org.sid.echallenge.dto.ProductDto
import org.sid.echallenge.entities.ProductEntity
import org.sid.echallenge.forms.ProductForm
import org.sid.echallenge.services.ProductService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(description = "API for CRUD operation on product")
@RestController
@RequestMapping("/products")
@CrossOrigin("*")
class ProductController(productService: ProductService) :
    CrudController<ProductForm, ProductDto, ProductEntity, ProductService>(productService)