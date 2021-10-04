package com.m3o1.util.http

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.Inet6Address


@Component
class ServerUtil(@Value("\${server.port}") port: Int) {
    // 현재 서버 정보를 저장
    final val serviceAddress: String

    init {
        val localHost = Inet6Address.getLocalHost()
        serviceAddress = "${localHost.hostName}/${localHost.hostAddress}:${port}"
    }
}