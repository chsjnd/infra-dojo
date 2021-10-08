package com.m3o1.server.review.findReviewApi

import com.m3o1.server.common.api.ApiResponse

interface FindReviewApi {
    fun findReview(productId: Int): ApiResponse<List<Review>>
}