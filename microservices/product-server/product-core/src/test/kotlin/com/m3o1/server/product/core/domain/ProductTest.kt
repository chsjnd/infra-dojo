package com.m3o1.server.product.core.domain

import com.m3o1.server.product.findProductApi.Product
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/**
 * Data Class에 대한 이해도가 낮아, Data Class가 정확히 어떤 역할을 수행해주는 지를 테스트 코드를 통해 학습
 *
 * kotlin에서의 Data Class
 * - toString()
 * - hashCode()
 * - Equals()
 * - copy()
 * 메소드를 자동으로 만들어주는 클래스.
 *
 * 데이터 클래스의 특징
 * - 상속받을 수 없습니다.
 * - val 또는 var으로 선언해야 합니다.
 * - abstract, open, sealed, inner을 붙일 수 없습니다.
 *
 *
 */

class ProductTest : AnnotationSpec() {

    @Test
    fun `product에 대한 생성자 테스트`() {
        val sut = Product(productId = 10, name = "abc", weight = null)

        sut.productId shouldBe 10
        sut.name shouldBe "abc"
        sut.weight shouldBe null
    }

    @Test
    fun `product에 대한 문자열 테스트`() {
        val sut = Product(productId = 10, name = "abc", weight = null)

        sut.toString() shouldBe "Product(productId=10, name=abc, weight=null)"
    }

    @Test
    fun `product에 대한 equal 테스트`() {
        val sut1 = Product(productId = 10, name = "abc", weight = null)
        val sut2 = Product(productId = 10, name = "abc", weight = null)
        val sut3 = Product(productId = 12, name = "abc", weight = null)

        sut1 shouldBe sut2
        sut1 shouldNotBe sut3
    }
}

