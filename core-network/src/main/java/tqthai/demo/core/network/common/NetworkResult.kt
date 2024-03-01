package tqthai.demo.core.network.common

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>

    data class Error(val exception: Throwable) : NetworkResult<Nothing>
}