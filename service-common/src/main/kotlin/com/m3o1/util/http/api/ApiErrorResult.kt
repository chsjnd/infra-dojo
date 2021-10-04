package com.m3o1.util.http.api

data class ApiErrorResult(
    val errorCode: Int = 0,
    val errorType: String = "",
    val message: String = "",
    val data: Map<String, Any> = mapOf()
)