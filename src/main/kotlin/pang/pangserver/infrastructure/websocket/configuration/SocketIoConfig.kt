package pang.pangserver.infrastructure.websocket.configuration

import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.Configuration as SocketIoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.boot.context.properties.EnableConfigurationProperties
import pang.pangserver.infrastructure.websocket.properties.SocketIoProperties

@Configuration
@EnableWebSocket
@EnableConfigurationProperties(SocketIoProperties::class)
class SocketIoConfig(
    private val properties: SocketIoProperties,
) {
    @Bean
    fun socketIoServer(): SocketIOServer {
        val config = SocketIoConfiguration()
        config.hostname = properties.host
        config.port = properties.port
        return SocketIOServer(config)
    }
}