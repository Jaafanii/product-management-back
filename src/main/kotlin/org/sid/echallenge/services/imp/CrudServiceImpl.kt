package org.sid.echallenge.services.imp

import org.sid.echallenge.dto.PageDto
import org.sid.echallenge.entities.BaseEntity
import org.sid.echallenge.mapper.EntityMapperService
import org.sid.echallenge.services.CrudService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

abstract class CrudServiceImpl<Form, Dto, Entity : BaseEntity, Repository : JpaRepository<Entity, Long>, Mapper : EntityMapperService<Entity, Dto>>(
    var repository: Repository,
    var mapper: Mapper
) :
    CrudService<Form, Dto, Entity> {

    override fun getOne(id: Long): Dto {
        return mapper.mapFromEntity(repository.getById(id))
    }

    override fun findById(id: Long): Entity {
        return repository.getById(id)
    }

    override fun getAll(currentPage: Int, size: Int): PageDto {
        val page: Page<Entity> = repository.findAll(Pageable.ofSize(size).withPage(currentPage))
        return PageDto(mapper.mapFromEntitiesList(page.content), page.totalPages)
    }

    override fun update(itemToUpdate: Form, id: Long) {
        repository.save(preUpdate(itemToUpdate, id))
    }

    override fun save(itemToSave: Form): Entity {
        return repository.save(preSave(itemToSave))

    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }
}
