package com.m3o1.server.productComposite.web.controller

import com.fasterxml.jackson.databind.JsonNode
import com.m3o1.server.productComposite.web.ControllerTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


class ProductCompositeControllerTest : ControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `productId를 1로 지정해서 호출하면, 1로 응답이 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/product-composite/1", JsonNode::class.java)

        responseEntity.body?.get("result")?.get("productId")?.asText() ?: "Unknown" shouldBe "1"
    }

    @Test
    fun `productId를 문자로 지정해서 호출하면, 400 코드가 내려온다`() {
        val responseEntity = restTemplate.getForEntity("/product-composite/abc", JsonNode::class.java)

        responseEntity.statusCode shouldBe HttpStatus.BAD_REQUEST
    }
}