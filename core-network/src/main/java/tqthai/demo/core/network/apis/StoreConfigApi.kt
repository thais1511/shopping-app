package tqthai.demo.core.network.apis

import retrofit2.Response
import retrofit2.http.GET
import tqthai.demo.core.network.entities.StoreConfigRemote

interface StoreConfigApi {

    @GET("V1/store/storeConfigs")
    suspend fun getStore(): Response<List<StoreConfigRemote>>
}