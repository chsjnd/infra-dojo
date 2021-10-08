package com.m3o1.server.recommendation.web.controller

import com.fasterxml.jackson.databind.JsonNode
import com.m3o1.server.recommendation.web.ControllerTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate


internal class HealthControllerTest : ControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `Health API를 호출하면, Status ok를 내려준다`() {
        val responseEntity = restTemplate.getForEntity("/health", JsonNode::class.java)
        responseEntity.body?.get("status")?.asText() ?: "Unknown" shouldBe "ok"
    }
}