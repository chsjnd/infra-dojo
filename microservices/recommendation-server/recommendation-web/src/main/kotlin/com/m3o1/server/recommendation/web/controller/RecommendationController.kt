package com.m3o1.server.recommendation.web.controller

import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.recommendation.core.domain.ProductRecommender
import com.m3o1.server.recommendation.findRecommendApi.FindRecommendApi
import com.m3o1.server.recommendation.findRecommendApi.Recommendation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecommendationController(private val productRecommender: ProductRecommender) : FindRecommendApi {

    @GetMapping("/recommendation")
    override fun findRecommendApi(@RequestParam(required = true) productId: Int): ApiResponse<List<Recommendation>> {
        val result = productRecommender.recommend(productId)
        return ApiResponse(result)
    }
}