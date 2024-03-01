package tqthai.demo.core.network.apis

import retrofit2.Response
import retrofit2.http.GET
import tqthai.demo.core.network.entities.CurrencyRemote

interface CurrencyApi {

    @GET("V1/directory/currency")
    suspend fun getCurrency(): Response<CurrencyRemote>
}