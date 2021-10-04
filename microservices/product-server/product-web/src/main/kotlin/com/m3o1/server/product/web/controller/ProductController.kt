package com.m3o1.server.product.web.controller

import com.m3o1.server.product.core.domain.Product
import com.m3o1.util.http.ServerUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val serverUtil: ServerUtil
) {
    @GetMapping("/products/{productId}")
    fun getProduct(@PathVariable productId: Int): Product {
        return Product(productId, "abc", 10, serverUtil.serviceAddress)
    }
}