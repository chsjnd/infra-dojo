package im.toss.util.http

import org.springframework.beans.factory.annotation.Value
import java.net.Inet6Address


class ServerUtil(@Value("#{server.port}") port: Int) {
    // 현재 서버 정보를 저장
    val serviceAddress: String

    init {
        val localHost = Inet6Address.getLocalHost()
        serviceAddress = "${localHost.hostName}/${localHost.hostAddress}:${port}"
    }
}