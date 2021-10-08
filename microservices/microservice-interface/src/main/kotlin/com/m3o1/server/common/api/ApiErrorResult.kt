package com.m3o1.server.common.api

data class ApiErrorResult(
    val errorCode: Int = 0,
    val errorType: String = "",
    val message: String = "",
    val data: Map<String, Any> = mapOf()
)