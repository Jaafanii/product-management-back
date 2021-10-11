package org.sid.echallenge.controllers

import io.swagger.annotations.ApiOperation
import org.sid.echallenge.dto.PageDto
import org.sid.echallenge.entities.BaseEntity
import org.sid.echallenge.services.CrudService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


open class CrudController<Form, Dto, Entity : BaseEntity, Service : CrudService<Form, Dto, Entity>>(val service: Service) {

    @ApiOperation(value = "To save an element")
    @PostMapping
    fun save(@RequestBody itemToSave: Form): ResponseEntity<Any> {
        val entity = service.save(itemToSave)
        val location: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(entity.id).toUri()

        return ResponseEntity.created(location).build()
    }

    @ApiOperation(value = "To get element by id")
    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): Dto {
        return service.getOne(id)
    }

    @ApiOperation(value = "To get page of elements")
    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): PageDto {

        return service.getAll(page, size)
    }

    @ApiOperation(value = "To update an element")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody itemToUpdate: Form
    ) {
        service.update(itemToUpdate, id)
    }

    @ApiOperation(value = "To delete an element")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}