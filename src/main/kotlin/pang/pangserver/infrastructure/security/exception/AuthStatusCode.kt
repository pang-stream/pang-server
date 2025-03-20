package pang.pangserver.infrastructure.security.exception

import pang.pangserver.core.exception.StatusCode

enum class AuthStatusCode(
    override val status: Int,
    override val message: String
): StatusCode {
    REFRESH_TOKEN_NOT_MATCH(404, " not found"),
}