package org.sid.echallenge.mapper

import org.sid.echallenge.dto.ProductDto
import org.sid.echallenge.entities.ProductEntity
import org.springframework.stereotype.Component

@Component
class ProductMapper(var categoryMapper: CategoryMapper) : EntityMapperService<ProductEntity, ProductDto> {
    override fun mapFromEntity(entity: ProductEntity): ProductDto {
        return ProductDto(
            entity.id!!, entity.name!!, entity.quantity!!, entity.price!!, categoryMapper.mapFromEntity(
                entity.category!!
            )
        )
    }

    override fun mapFromEntitiesList(entities: List<ProductEntity>): List<ProductDto> {
        return entities.map { mapFromEntity(it) }
    }
}