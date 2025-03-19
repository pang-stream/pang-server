package pang.pangserver.application.support.token.enumeration

enum class TokenType(
    val value: String,
) {
    ACCESS_TOKEN("access"),
    REFRESH_TOKEN("refresh")
    ;
    companion object {
        fun toTokenType(string: String): TokenType =
            entries.find { it.value == string } ?: throw IllegalArgumentException("Unknown token type: $string")
    }
}