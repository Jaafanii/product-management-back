package org.sid.echallenge.mapper

import org.sid.echallenge.entities.BaseEntity

interface EntityMapperService<Entity: BaseEntity, Dto> {
    fun mapFromEntity(entity: Entity): Dto;
    fun mapFromEntitiesList(entities: List<Entity>): List<Dto>;
}