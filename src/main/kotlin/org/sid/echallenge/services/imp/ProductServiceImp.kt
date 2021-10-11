package org.sid.echallenge.services.imp

import org.sid.echallenge.dto.ProductDto
import org.sid.echallenge.entities.ProductEntity
import org.sid.echallenge.forms.ProductForm
import org.sid.echallenge.mapper.ProductMapper
import org.sid.echallenge.repositories.ProductRepository
import org.sid.echallenge.services.ProductService
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

@Service
class ProductServiceImp(
    repository: ProductRepository,
    var categoryService: CategoryService,
    productMapper: ProductMapper
) :
    ProductService,
    CrudServiceImpl<ProductForm, ProductDto, ProductEntity, ProductRepository, ProductMapper>(
        repository,
        productMapper
    ) {

    override fun preSave(itemToSave: ProductForm): ProductEntity {
        return constructEntity(itemToSave);
    }

    override fun preUpdate(itemToUpdate: ProductForm, id: Long): ProductEntity {
        val productEntity = constructEntity(itemToUpdate)
        productEntity.id = id
        return productEntity
    }

    private fun constructEntity(product: ProductForm): ProductEntity {
        val productEntity = ProductEntity()
        BeanUtils.copyProperties(product, productEntity)
        productEntity.category = categoryService.findById(product.categoryId);
        return productEntity
    }
}