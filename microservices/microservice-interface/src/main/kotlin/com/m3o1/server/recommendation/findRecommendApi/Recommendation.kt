package com.m3o1.server.recommendation.findRecommendApi

data class Recommendation(
    val productId: Int,
    val recommendationId: Int,
    val author: String,
    val rate: Int,
    val content: String
)
