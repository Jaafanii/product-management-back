package org.sid.echallenge.services.imp

import org.sid.echallenge.dto.CategoryDto
import org.sid.echallenge.entities.CategoryEntity
import org.sid.echallenge.forms.CategoryForm
import org.sid.echallenge.mapper.CategoryMapper
import org.sid.echallenge.repositories.CategoryRepository
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