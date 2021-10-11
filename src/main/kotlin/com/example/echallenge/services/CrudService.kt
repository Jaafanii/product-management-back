package com.example.echallenge.services

import com.example.echallenge.dto.PageDto
import com.example.echallenge.entities.BaseEntity

/**Generic service for crud operation
 * @param <Form> represent element we get from client (element to save or to update)
 * @param <Dto> represent return type
 * @param <Entity> represent the Entity type
 * @author JAAFANI Mohamed
 * @version 1.0
 * @return an ApiErrorVO who will contain exception message
 */
interface CrudService<Form, Dto, Entity : BaseEntity> {

    /**to get an element of type Entity mapped to Dto type
     * @param id: entity id
     * @author JAAFANI Mohamed
     * @version 1.0
     * @return dto
     */
    fun getOne(id: Long): Dto

    /**to get an Entity by it's id
     * @param id entity id
     * @author JAAFANI Mohamed
     * @version 1.0
     */
    fun findById(id: Long): Entity

    /**to get page of elements
     * @param currentPage index of the page to get
     * @param size page size (element by page)
     * @author JAAFANI Mohamed
     * @version 1.0
     * @return pageDto: contains list of Dto and number of totalPages
     */
    fun getAll(currentPage: Int, size: Int): PageDto

    /**to update an Entity
     * @param itemToUpdate the item that we want to update
     * @param id id of the element to update
     * @author JAAFANI Mohamed
     * @version 1.0
     */
    fun update(itemToUpdate: Form, id: Long)

    /**to save an element of type Entity
     * @param itemToSave the item that we want to save
     * @author JAAFANI Mohamed
     * @return save Element
     * @version 1.0
     */
    fun save(itemToSave: Form): Entity

    /**to to map object of type Form to Entity type and if you wand to do something before saving the element,
     *  also to avoid to override 'save' method
     * @param itemToSave the item that we want to save
     * @author JAAFANI Mohamed
     * @return saved Element
     * @version 1.0
     */
    fun preSave(itemToSave: Form): Entity

    /**to to map object of type Form to Entity type and if you wand to do something before updating the element,
     *  also to avoid to override 'update' method
     * @param itemToUpdate the item that we want to update
     * @param id id of the element that we want to update
     * @author JAAFANI Mohamed
     * @return updated element
     * @version 1.0
     */
    fun preUpdate(itemToUpdate: Form, id: Long): Entity

    /**to delete en element
     * @param id id of the element that we want to delete
     * @author JAAFANI Mohamed
     * @version 1.0
     */
    fun delete(id: Long)
}