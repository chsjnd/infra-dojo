package com.m3o1.server.product.web.controller

import com.m3o1.server.product.core.domain.Product
import com.m3o1.server.product.core.domain.ProductFinder
import com.m3o1.util.http.api.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productFinder: ProductFinder) {

    @GetMapping("/products/{productId}")
    fun getProduct(@PathVariable productId: Int): ApiResponse<Product> {
        val result = productFinder.find(productId)
        return ApiResponse(result)
    }
}