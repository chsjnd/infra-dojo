package com.m3o1.server.productComposite.core.domain

import com.m3o1.server.product.findProductApi.ProductApi
import com.m3o1.server.productComposite.productCompositeApi.ProductAggregate
import com.m3o1.server.productComposite.productCompositeApi.RecommendationSummary
import com.m3o1.server.productComposite.productCompositeApi.ReviewSummary
import com.m3o1.server.recommendation.findRecommendApi.FindRecommendApi
import com.m3o1.server.review.findReviewApi.FindReviewApi
import org.springframework.stereotype.Component

@Component
class ProductAggregater(
    private val findReviewApi: FindReviewApi,
    private val findProductApi: ProductApi,
    private val findRecommendApi: FindRecommendApi
) {

    fun aggregate(productId: Int): ProductAggregate {
        val product = findProductApi.findProduct(productId).result ?: throw Exception("데이터를 찾지 못했습니다.")
        return ProductAggregate(
            product.productId,
            product.name,
            product.weight,
            getRecommendationSummary(productId),
            getReviewSummary(productId)
        )
    }

    private fun getRecommendationSummary(productId: Int): List<RecommendationSummary> {
        return findRecommendApi.findRecommendApi(productId)
            .result
            ?.map { e -> RecommendationSummary(e.recommendationId, e.author, e.rate) }
            ?: listOf();
    }

    private fun getReviewSummary(productId: Int): List<ReviewSummary> {
        return findReviewApi.findReview(productId)
            .result
            ?.map { e -> ReviewSummary(e.reviewId, e.author, e.subject) }
            ?: listOf();
    }
}