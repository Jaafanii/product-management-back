package com.example.echallenge.repositories

import com.example.echallenge.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long>