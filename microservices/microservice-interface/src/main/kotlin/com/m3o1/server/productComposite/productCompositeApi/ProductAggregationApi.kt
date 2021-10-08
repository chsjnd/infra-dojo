package com.m3o1.server.productComposite.productCompositeApi

import com.m3o1.server.common.api.ApiResponse

interface ProductAggregationApi {

    /**
     * productId를 통해 Aggregation된 Product정보를 조회
     */
    fun getAggregatedProductInfo(productId: Int): ApiResponse<ProductAggregate>
}