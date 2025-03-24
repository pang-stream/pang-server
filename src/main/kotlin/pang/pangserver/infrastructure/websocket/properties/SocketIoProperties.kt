package pang.pangserver.infrastructure.websocket.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "socket")
data class SocketIoProperties(
    val host: String,
    val port: Int
)