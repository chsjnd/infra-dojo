package com.m3o1.server.product.web.controller

import com.fasterxml.jackson.databind.JsonNode
import com.m3o1.server.product.web.ControllerTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


class ProductControllerTest : ControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `productId를 1로 지정해서 호출하면, 1로 응답이 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/products/1", JsonNode::class.java)
        responseEntity.body?.get("productId")?.asText() ?: "Unknown" shouldBe "1"
    }

    @Test
    fun `productId를 문자로 지정해서 호출하면, 400 코드가 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/products/abc", JsonNode::class.java)
        responseEntity.statusCode shouldBe HttpStatus.BAD_REQUEST
    }
}