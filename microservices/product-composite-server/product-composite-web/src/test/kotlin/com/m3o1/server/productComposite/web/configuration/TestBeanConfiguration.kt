package com.m3o1.server.productComposite.web.configuration

import com.m3o1.server.product.findProductApi.ProductApi
import com.m3o1.server.recommendation.findRecommendApi.FindRecommendApi
import com.m3o1.server.review.findReviewApi.FindReviewApi
import com.m3o1.util.http.ServerUtil
import io.mockk.mockk
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class TestBeanConfiguration {

    @Bean
    fun serverUtil(): ServerUtil {
        return ServerUtil(8080)
    }

    @Bean
    @Primary
    fun findReviewApi(): FindReviewApi {
        return mockk(relaxed = true)
    }

    @Bean
    @Primary
    fun productApi(): ProductApi {
        return mockk(relaxed = true)
    }

    @Bean
    @Primary
    fun findRecommendApi(): FindRecommendApi {
        return mockk(relaxed = true)
    }
}