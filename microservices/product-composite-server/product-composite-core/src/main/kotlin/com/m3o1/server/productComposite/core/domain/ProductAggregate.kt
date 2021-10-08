package com.m3o1.server.productComposite.core.domain

data class ProductAggregate(
    val productId: Int,
    val name: String,
    val weight: Int,
    val recommendations: List<RecommendationSummary>,
    val reviews: List<ReviewSummary>
)
