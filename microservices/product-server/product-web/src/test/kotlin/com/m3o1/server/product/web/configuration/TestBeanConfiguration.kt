package com.m3o1.server.product.web.configuration

import com.m3o1.util.http.ServerUtil
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestBeanConfiguration {

    @Bean
    fun serverUtil(): ServerUtil {
        return ServerUtil(8080)
    }
}