package pang.pangserver.infrastructure.security.exception

import pang.pangserver.core.exception.BasicException

class RefreshTokenNotMatchException : BasicException(AuthStatusCode.REFRESH_TOKEN_NOT_MATCH)