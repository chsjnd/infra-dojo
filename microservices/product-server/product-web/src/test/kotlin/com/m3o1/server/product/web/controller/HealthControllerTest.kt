package com.m3o1.server.product.web.controller

import com.fasterxml.jackson.databind.JsonNode
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class HealthControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Health API를 호출하면, Status ok를 내려준다`() {
        val responseEntity = restTemplate.getForEntity("/health", JsonNode::class.java)
        responseEntity.body?.get("status")?.asText() ?: "Unknown" shouldBe "ok"
    }
}