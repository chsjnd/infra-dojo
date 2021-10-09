package com.m3o1.api

import com.m3o1.server.common.api.ApiErrorResult
import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.product.findProductApi.Product
import com.m3o1.server.product.findProductApi.ProductApi
import com.m3o1.server.recommendation.findRecommendApi.FindRecommendApi
import com.m3o1.server.recommendation.findRecommendApi.Recommendation
import com.m3o1.server.review.findReviewApi.FindReviewApi
import com.m3o1.server.review.findReviewApi.Review
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class InternalServerClient(
    @Value("\${services.host.product-server}") private val productHost: String,
    @Value("\${services.host.review-server}") private val reviewHost: String,
    @Value("\${services.host.recommendation-server}") private val recommendHost: String,
    private val internalRestTemplate: RestTemplate
) : FindReviewApi, FindRecommendApi, ProductApi {
    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}

    override fun findProduct(productId: Int): ApiResponse<Product> {
        try {
            val response =
                internalRestTemplate.exchange(
                    "${productHost}/products/${productId}",
                    HttpMethod.GET,
                    null,
                    typeReference<ApiResponse<Product>>()
                )
            return response.body ?: ApiResponse(ApiErrorResult(0, "INTERNAL_SERVER_ERROR", "호출에 실패하였습니다."))
        } catch (e: Exception) {
            return ApiResponse(
                ApiErrorResult(
                    errorType = "INTERNAL_SERVER_ERROR",
                    message = e.message ?: "호출에 실패하였습니다."
                )
            )
        }
    }

    override fun findReview(productId: Int): ApiResponse<List<Review>> {
        try {
            val response =
                internalRestTemplate.exchange(
                    "${reviewHost}/reviews?productId=${productId}",
                    HttpMethod.GET,
                    null,
                    typeReference<ApiResponse<List<Review>>>()
                )
            return response.body ?: ApiResponse(ApiErrorResult(0, "INTERNAL_SERVER_ERROR", "호출에 실패하였습니다."))
        } catch (e: Exception) {
            return ApiResponse(
                ApiErrorResult(
                    errorType = "INTERNAL_SERVER_ERROR",
                    message = e.message ?: "호출에 실패하였습니다."
                )
            )
        }
    }

    override fun findRecommendApi(productId: Int): ApiResponse<List<Recommendation>> {
        try {
            val response =
                internalRestTemplate.exchange(
                    "${recommendHost}/recommendation?productId=${productId}",
                    HttpMethod.GET,
                    null,
                    typeReference<ApiResponse<List<Recommendation>>>()
                )
            return response.body ?: ApiResponse(ApiErrorResult(0, "INTERNAL_SERVER_ERROR", "호출에 실패하였습니다."))
        } catch (e: Exception) {
            return ApiResponse(
                ApiErrorResult(
                    errorType = "INTERNAL_SERVER_ERROR",
                    message = e.message ?: "호출에 실패하였습니다."
                )
            )
        }
    }
}