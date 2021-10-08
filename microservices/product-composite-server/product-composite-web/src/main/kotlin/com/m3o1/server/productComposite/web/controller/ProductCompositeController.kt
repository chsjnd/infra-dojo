package com.m3o1.server.productComposite.web.controller

import com.m3o1.server.productComposite.core.domain.ProductAggregate
import com.m3o1.server.productComposite.core.domain.ProductAggregater
import com.m3o1.util.http.api.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductCompositeController(private val productAggregater: ProductAggregater) {

    @GetMapping("/product-composite/{productId}")
    fun getProduct(@PathVariable productId: Int): ApiResponse<ProductAggregate> {
        val result = productAggregater.aggregate(productId)
        return ApiResponse(result)
    }
}