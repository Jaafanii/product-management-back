package org.sid.echallenge.controllers

import org.sid.echallenge.dto.CategoryDto
import org.sid.echallenge.entities.CategoryEntity
import org.sid.echallenge.forms.CategoryForm
import org.sid.echallenge.services.imp.CategoryService
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