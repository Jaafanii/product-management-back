package com.example.echallenge.services.imp

import com.example.echallenge.dto.ProductDto
import com.example.echallenge.entities.ProductEntity
import com.example.echallenge.forms.ProductForm
import com.example.echallenge.mapper.ProductMapper
import com.example.echallenge.repositories.ProductRepository
import com.example.echallenge.services.ProductService
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