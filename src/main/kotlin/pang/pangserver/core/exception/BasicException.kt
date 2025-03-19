package pang.pangserver.core.exception

open class BasicException(
    val statusCode:StatusCode
): RuntimeException()