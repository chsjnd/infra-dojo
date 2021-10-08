package com.m3o1.server.common.api

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiResponse<S> {
    val resultType: ResultType
    val result: S?
    val error: ApiErrorResult?

    constructor(result: S) {
        this.resultType = ResultType.SUCCESS;
        this.result = result
        this.error = null
    }

    constructor(error: ApiErrorResult) {
        this.resultType = ResultType.FAIL
        this.result = null
        this.error = error
    }

    @JsonIgnore
    fun isSuccess(): Boolean {
        return resultType.isSuccess()
    }

    @JsonIgnore
    fun isFail(): Boolean {
        return resultType.isFail()
    }
}