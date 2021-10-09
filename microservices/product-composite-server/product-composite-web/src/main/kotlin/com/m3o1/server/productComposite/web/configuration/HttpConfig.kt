package com.m3o1.server.productComposite.web.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class HttpConfig {

    @Bean
    fun internalServerRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}