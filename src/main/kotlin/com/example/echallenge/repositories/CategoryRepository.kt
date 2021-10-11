package com.example.echallenge.repositories

import com.example.echallenge.entities.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<CategoryEntity, Long>