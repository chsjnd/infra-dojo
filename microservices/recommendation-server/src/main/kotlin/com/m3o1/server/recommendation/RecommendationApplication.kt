package com.m3o1.server.recommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecommendationApplication

fun main(args: Array<String>) {
    runApplication<RecommendationApplication>(*args)
}