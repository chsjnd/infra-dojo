package com.m3o1.server.recommendation.findRecommendApi

import com.m3o1.server.common.api.ApiResponse

interface FindRecommendApi {
    fun findRecommendApi(productId: Int): ApiResponse<List<Recommendation>>
}