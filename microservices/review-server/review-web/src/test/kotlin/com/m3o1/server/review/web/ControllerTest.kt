package com.m3o1.server.review.web

import com.m3o1.server.review.web.configuration.TestBeanConfiguration
import com.m3o1.server.review.web.configuration.WebConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(
    TestBeanConfiguration::class,
    WebConfiguration::class
)
interface ControllerTest