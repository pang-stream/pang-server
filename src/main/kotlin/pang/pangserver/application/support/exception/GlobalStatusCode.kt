package pang.pangserver.application.support.exception

import pang.pangserver.core.exception.StatusCode

enum class GlobalStatusCode(
    override val status: Int,
    override val message: String
): StatusCode {
    INTERNAL_SERVER_ERROR(500, "Pang Internal Server Error"),
}