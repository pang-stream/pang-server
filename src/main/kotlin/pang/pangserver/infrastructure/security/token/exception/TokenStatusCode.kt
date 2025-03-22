package pang.pangserver.infrastructure.security.token.exception

import pang.pangserver.core.exception.StatusCode

enum class TokenStatusCode(
    override val status: Int,
    override val message: String
): StatusCode {
    TOKEN_EXPIRED(400, "token expired"),
    TOKEN_INVALID(404, "token invalid"),
    FAKE_TOKEN(409, "fake token"),
    EMPTY_TOKEN(401, "empty token")
}