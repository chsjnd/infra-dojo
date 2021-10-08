package com.m3o1.server.productComposite.core.domain

import org.springframework.stereotype.Component

@Component
class ProductAggregater {

    fun aggregate(productId: Int): ProductAggregate {
        return ProductAggregate(
            productId,
            "abd",
            1,
            listOf(RecommendationSummary(1, "abc", 1)),
            listOf(ReviewSummary(1, "abc", "mathematics")),
        )
    }
}