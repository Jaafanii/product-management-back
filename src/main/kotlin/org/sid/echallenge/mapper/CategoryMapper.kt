package org.sid.echallenge.mapper

import org.sid.echallenge.dto.CategoryDto
import org.sid.echallenge.entities.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryMapper : EntityMapperService<CategoryEntity, CategoryDto> {
    override fun mapFromEntity(entity: CategoryEntity): CategoryDto {
        return CategoryDto(entity.id!!, entity.name!!, entity.description!!);
    }

    override fun mapFromEntitiesList(entities: List<CategoryEntity>): List<CategoryDto> {
        return entities.map { mapFromEntity(it) }
    }

}