package org.sid.echallenge.repositories

import org.sid.echallenge.entities.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<CategoryEntity, Long>