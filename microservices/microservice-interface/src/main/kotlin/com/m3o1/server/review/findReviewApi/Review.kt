package com.m3o1.server.review.findReviewApi

data class Review(
    val productId: Int,
    val reviewId: Int,
    val author: String,
    val subject: String,
    val content: String
)
