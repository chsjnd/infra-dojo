package com.m3o1.server.productComposite.web.controller

import com.fasterxml.jackson.databind.JsonNode
import com.m3o1.server.common.api.ApiResponse
import com.m3o1.server.product.findProductApi.Product
import com.m3o1.server.product.findProductApi.ProductApi
import com.m3o1.server.productComposite.web.ControllerTest
import com.m3o1.server.recommendation.findRecommendApi.FindRecommendApi
import com.m3o1.server.recommendation.findRecommendApi.Recommendation
import com.m3o1.server.review.findReviewApi.FindReviewApi
import com.m3o1.server.review.findReviewApi.Review
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


class ProductCompositeControllerTest : ControllerTest {

    @Autowired
    lateinit var productApi: ProductApi

    @Autowired
    lateinit var reviewApi: FindReviewApi

    @Autowired
    lateinit var recommendationApi: FindRecommendApi

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @BeforeEach
    fun setup() {
        every { productApi.findProduct(any()) } returns ApiResponse(
            Product(1, "mock", 10)
        )
        every { reviewApi.findReview(any()) } returns ApiResponse(
            listOf(Review(1, 1, "mock", "", ""))
        )
        every { recommendationApi.findRecommendApi(any()) } returns ApiResponse(
            listOf(Recommendation(1, 1, "mock", 1, ""))
        )
    }

    @Test
    fun `productId를 1로 지정해서 호출하면, 1로 응답이 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/product-composite/1", JsonNode::class.java)

        responseEntity.body?.get("result")?.get("productId")?.asText() ?: "Unknown" shouldBe "1"
        responseEntity.body?.get("result")?.get("name")?.asText() ?: "Unknown" shouldBe "mock"
        responseEntity.body?.get("result")?.get("weight")?.asText() ?: "Unknown" shouldBe "10"
    }

    @Test
    fun `productId를 문자로 지정해서 호출하면, 400 코드가 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/product-composite/abc", JsonNode::class.java)

        responseEntity.statusCode shouldBe HttpStatus.BAD_REQUEST
    }

    private fun givenProductIdIs(productId: Int) {
        every { productApi.findProduct(any()) } returns ApiResponse(
            Product(productId, "mock", 10)
        )
    }
}