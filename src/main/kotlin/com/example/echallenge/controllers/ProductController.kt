package com.example.echallenge.controllers

import com.example.echallenge.dto.ProductDto
import com.example.echallenge.entities.ProductEntity
import com.example.echallenge.forms.ProductForm
import com.example.echallenge.services.ProductService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(description = "API for CRUD operation on product")
@RestController
@RequestMapping("/products")
@CrossOrigin("*")
class ProductController(productService: ProductService) :
    CrudController<ProductForm, ProductDto, ProductEntity, ProductService>(productService)