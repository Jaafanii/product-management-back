package com.example.echallenge.mapper

import com.example.echallenge.entities.BaseEntity

interface EntityMapperService<Entity: BaseEntity, Dto> {
    fun mapFromEntity(entity: Entity): Dto;
    fun mapFromEntitiesList(entities: List<Entity>): List<Dto>;
}