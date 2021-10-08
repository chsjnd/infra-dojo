package com.m3o1.server.product.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.m3o1")
class ProductApplication

fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}