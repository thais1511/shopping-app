package tqthai.demo.core.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import tqthai.demo.core.network.apis.CurrencyApi
import tqthai.demo.core.network.apis.StoreConfigApi
import tqthai.demo.core.network.datasources.ConfigRemoteDatasource
import tqthai.demo.core.network.datasources.ConfigRemoteDatasourceImpl
import tqthai.demo.core.network.interceptors.AccessTokenInterceptor
import tqthai.demo.shoppingapp.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModuleProvide {

    @Binds
    fun bindConfigRemoteDatasource(remoteDatasourceImpl: ConfigRemoteDatasourceImpl) : ConfigRemoteDatasource
}

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        moshiConvertFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(moshiConvertFactory).baseUrl(BuildConfig.baseUrl).client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi {
        return retrofit.create(CurrencyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideStoreConfigApi(retrofit: Retrofit): StoreConfigApi {
        return retrofit.create(StoreConfigApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory{
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return MoshiConverterFactory.create(moshi)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(AccessTokenInterceptor(accessToken = BuildConfig.accessToken))
        if(BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun profileHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}