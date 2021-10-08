package com.m3o1.server.product.web.controller

import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.product.core.domain.ProductFinder
import com.m3o1.server.product.findProductApi.Product
import com.m3o1.server.product.findProductApi.ProductApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productFinder: ProductFinder) : ProductApi {

    @GetMapping("/products/{productId}")
    override fun findProduct(@PathVariable productId: Int): ApiResponse<Product> {
        val result = productFinder.find(productId)
        return ApiResponse(result)
    }
}