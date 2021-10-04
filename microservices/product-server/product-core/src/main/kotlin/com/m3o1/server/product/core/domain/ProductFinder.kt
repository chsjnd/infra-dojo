package com.m3o1.server.product.core.domain

import org.springframework.stereotype.Component

@Component
class ProductFinder {
    fun find(id: Int): Product {
        return Product(id, "MOCK", 10)
    }
}