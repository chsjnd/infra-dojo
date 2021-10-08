package com.m3o1.server.recommendation.web.controller

import com.m3o1.server.recommendation.core.domain.ProductRecommender
import com.m3o1.server.recommendation.core.domain.Recommendation
import com.m3o1.util.http.api.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecommendationController(private val productRecommender: ProductRecommender) {

    @GetMapping("/recommendation")
    fun getProduct(@RequestParam(required=true) productId: Int): ApiResponse<List<Recommendation>> {
        val result = productRecommender.recommend(productId)
        return ApiResponse(result)
    }
}