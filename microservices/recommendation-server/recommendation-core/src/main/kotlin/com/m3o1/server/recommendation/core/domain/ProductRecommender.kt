package com.m3o1.server.recommendation.core.domain

import org.springframework.stereotype.Component

@Component
class ProductRecommender {
    fun recommend(productId: Int): List<Recommendation> {
        if (productId < 1) {
            throw Exception("Invalid productId: $productId")
        }

        if (productId == 113) {
            return listOf()
        }

        return listOf(
            Recommendation(productId, 1, "Author 1", 1, "Content 1"),
            Recommendation(productId, 2, "Author 2", 2, "Content 2"),
            Recommendation(productId, 3, "Author 3", 3, "Content 3"),
        )
    }
}