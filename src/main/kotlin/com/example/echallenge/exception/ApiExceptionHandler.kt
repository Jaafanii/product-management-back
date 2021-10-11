package com.example.echallenge.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.persistence.EntityNotFoundException

/** to handle jpa exception.
 * @author JAAFANI Mohamed
 * @version 1.0
 * @return an ApiErrorVO who will contain exception message
 */
@ControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleValidationError(ex: EntityNotFoundException): ApiErrorVO {
        val message = ex.message
        if (message!!.contains("CategoryEntity")) {
            return ApiErrorVO("category.not.found", "Category not found")
        }
        return ApiErrorVO("product.not.found", "Product not found")

    }
}