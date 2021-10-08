package com.m3o1.server.review.web.controller

import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.review.core.domain.ReviewReader
import com.m3o1.server.review.findReviewApi.FindReviewApi
import com.m3o1.server.review.findReviewApi.Review
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    val reviewReader: ReviewReader
) : FindReviewApi {
    @GetMapping("/reviews")
    override fun findReview(@RequestParam(required = true) productId: Int): ApiResponse<List<Review>> {
        val result = reviewReader.readByProductId(productId)
        return ApiResponse(result)
    }
}