package pang.pangserver.infrastructure.security.token.exception

import pang.pangserver.core.exception.BasicException

class FakeTokenException: BasicException(TokenStatusCode.FAKE_TOKEN)
class TokenExpiredException: BasicException(TokenStatusCode.TOKEN_EXPIRED)
class InvalidTokenException: BasicException(TokenStatusCode.TOKEN_INVALID)
class EmptyTokenException: BasicException(TokenStatusCode.EMPTY_TOKEN)