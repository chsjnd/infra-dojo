package com.m3o1.util.http.api

enum class ResultType {
    SUCCESS,
    HTTP_TIMEOUT,
    NETWORK_ERROR,
    EXECUTION_FAIL,
    INTERRUPTED,
    INTERNAL_ERROR,
    FAIL;

    fun isSuccess(): Boolean {
        return this == SUCCESS
    }

    fun isFail(): Boolean {
        return !isSuccess()
    }
}