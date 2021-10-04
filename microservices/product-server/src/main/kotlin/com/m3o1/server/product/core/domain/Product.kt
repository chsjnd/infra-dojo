package com.m3o1.server.product.core.domain

data class Product(
    val productId: Int,
    val name: String,
    val weight: Int?,
    val serviceAddress: String="localhost"
)
