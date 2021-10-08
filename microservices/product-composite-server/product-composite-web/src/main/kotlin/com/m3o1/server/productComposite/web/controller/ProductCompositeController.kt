package com.m3o1.server.productComposite.web.controller

import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.productComposite.core.domain.ProductAggregater
import com.m3o1.server.productComposite.productCompositeApi.ProductAggregate
import com.m3o1.server.productComposite.productCompositeApi.ProductAggregationApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductCompositeController(private val productAggregater: ProductAggregater) : ProductAggregationApi {

    @GetMapping("/product-composite/{productId}")
    override fun getAggregatedProductInfo(@PathVariable productId: Int): ApiResponse<ProductAggregate> {
        val result = productAggregater.aggregate(productId)
        return ApiResponse(result)
    }
}