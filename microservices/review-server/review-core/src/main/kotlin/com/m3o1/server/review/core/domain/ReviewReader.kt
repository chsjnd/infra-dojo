package com.m3o1.server.review.core.domain

import org.springframework.stereotype.Component

@Component
class ReviewReader {

    fun readByProductId(productId: Int): List<Review> {
        return listOf(
            Review(productId, 1, "강상재", "개발", "스프링 전반"),
            Review(productId, 2, "조서형", "영업", "B2B에서의 영업"),
        )
    }
}