package com.m3o1.server.productComposite.web

import com.m3o1.server.productComposite.web.configuration.TestBeanConfiguration
import com.m3o1.server.productComposite.web.configuration.WebConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(
    TestBeanConfiguration::class,
    WebConfiguration::class
)
interface ControllerTest