package com.m3o1.util.http

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ServiceUtilsTest : AnnotationSpec() {

    @Test
    fun `serviceUtils`() {
        val serviceUtils = ServerUtil(123)
        val port = serviceUtils.serviceAddress.split(":").reversed()[0]
        port shouldBe "123"
    }
}