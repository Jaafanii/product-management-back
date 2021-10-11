package org.sid.echallenge.repositories

import org.sid.echallenge.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long>