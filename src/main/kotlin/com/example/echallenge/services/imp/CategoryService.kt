package com.example.echallenge.services.imp

import com.example.echallenge.dto.CategoryDto
import com.example.echallenge.entities.CategoryEntity
import com.example.echallenge.forms.CategoryForm
import com.example.echallenge.mapper.CategoryMapper
import com.example.echallenge.repositories.CategoryRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

@Service
class CategoryService(repository: CategoryRepository, categoryMapper: CategoryMapper) :
    CrudServiceImpl<CategoryForm, CategoryDto, CategoryEntity, CategoryRepository, CategoryMapper>(
        repository,
        categoryMapper
    ) {

    override fun preSave(itemToSave: CategoryForm): CategoryEntity {
       return constructEntity(itemToSave)
    }

    override fun preUpdate(itemToUpdate: CategoryForm, id: Long): CategoryEntity {
        val categoryEntity = constructEntity(itemToUpdate)
        categoryEntity.id = id
        return categoryEntity
    }

    private fun constructEntity(category: CategoryForm): CategoryEntity {
        val categoryEntity = CategoryEntity()
        BeanUtils.copyProperties(category, categoryEntity)
        return categoryEntity
    }
}