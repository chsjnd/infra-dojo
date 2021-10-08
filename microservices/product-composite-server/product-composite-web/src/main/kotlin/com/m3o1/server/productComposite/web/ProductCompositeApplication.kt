package com.m3o1.server.productComposite.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.m3o1")
class ProductCompositeApplication

fun main(args: Array<String>) {
    runApplication<ProductCompositeApplication>(*args)
}