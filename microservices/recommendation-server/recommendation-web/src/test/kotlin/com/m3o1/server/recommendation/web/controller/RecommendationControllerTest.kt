package com.m3o1.server.recommendation.web.controller

import com.fasterxml.jackson.databind.JsonNode
import com.m3o1.server.recommendation.web.ControllerTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate


class RecommendationControllerTest : ControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `productId를 2로 지정해서 호출하면, 2로 응답이 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/recommendation?productId=2", JsonNode::class.java)

        responseEntity.body?.get("result")?.get(0)?.get("productId")?.asText() ?: "Unknown" shouldBe "2"
    }
}