package com.m3o1.server.product.findProductApi

import com.m3o1.server.common.api.ApiResponse

interface ProductApi {
    /**
     * productId를 통해 Product 정보를 조회
     */
    fun findProduct(productId: Int): ApiResponse<Product>
}