package tqthai.demo.core.network.datasources

import retrofit2.Response
import tqthai.demo.core.network.common.NetworkResult
open class BaseRemoteDatasource {

    protected suspend fun <T: Any> callApi(call :suspend () -> Response<T>): NetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (e: Exception){
            return NetworkResult.Error(exception = e)
        }
        if(response.isSuccessful){
            response.body()?.let {
                return NetworkResult.Success(it)
            } ?: run {
                return NetworkResult.Error(exception = Exception("body is empty"))
            }

        } else {
            response.errorBody()?.toString()?.let {
                val networkException = NetworkException()
                networkException.parse(response.errorBody().toString())
                return NetworkResult.Error(networkException)
            } ?: run {
              return NetworkResult.Error(exception = Exception(response.message()))
            }

        }
    }
}