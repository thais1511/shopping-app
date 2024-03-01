package tqthai.demo.core.network.datasources

import tqthai.demo.core.network.apis.CurrencyApi
import tqthai.demo.core.network.apis.StoreConfigApi
import tqthai.demo.core.network.common.NetworkResult
import tqthai.demo.core.network.entities.CurrencyRemote
import tqthai.demo.core.network.entities.StoreConfigRemote
import javax.inject.Inject

interface ConfigRemoteDatasource {

    suspend fun getCurrency(): NetworkResult<CurrencyRemote>

    suspend fun getStoreConfigs(): NetworkResult<List<StoreConfigRemote>>
}

class ConfigRemoteDatasourceImpl @Inject constructor(
    private val currencyApi: CurrencyApi,
    private val storeConfigApi: StoreConfigApi
): BaseRemoteDatasource(), ConfigRemoteDatasource {
    override suspend fun getCurrency(): NetworkResult<CurrencyRemote> {
        return callApi {
            currencyApi.getCurrency()
        }
    }

    override suspend fun getStoreConfigs(): NetworkResult<List<StoreConfigRemote>> {
        return callApi {
            storeConfigApi.getStore()
        }
    }


}