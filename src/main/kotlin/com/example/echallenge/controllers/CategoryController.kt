package com.example.echallenge.controllers

import com.example.echallenge.dto.CategoryDto
import com.example.echallenge.entities.CategoryEntity
import com.example.echallenge.forms.CategoryForm
import com.example.echallenge.services.imp.CategoryService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(description = "API for CRUD operation on category")
@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
class CategoryController(categoryService: CategoryService) :
    CrudController<CategoryForm, CategoryDto, CategoryEntity, CategoryService>(categoryService)