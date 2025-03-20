package pang.pangserver.application.support.data

import org.springframework.http.HttpStatus

class DataResponse<T>(
    override val status: Int,
    override val message: String,
    val data: T
): Response(status, message) {
    companion object {
        fun<T> of(status: HttpStatus, message: String, data: T): DataResponse<T> {
            return DataResponse(status.value(), message, data)
        }

        fun<T> ok(message: String, data: T): DataResponse<T> {
            return DataResponse(HttpStatus.OK.value(), message, data)
        }

        fun<T> created(message: String, data: T): DataResponse<T> {
            return DataResponse(HttpStatus.CREATED.value(), message, data)
        }
    }
}