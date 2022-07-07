package com.mm.currencyconverter.di

import com.mm.data.CurrenciesRepositoryImpl
import com.mm.data.remote.CurrencyApi
import com.mm.data.remote.utils.Constants.BASE_URL
import com.mm.domain.CurrencyRepository
import com.mm.domain.use_cases.GetCurrenciesUseCase
import com.mm.domain.use_cases.GetLatestRatesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CurrencyModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideCurrencyApi(httpLoggingInterceptor: HttpLoggingInterceptor): CurrencyApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(CurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO

    @Provides
    @Singleton
    fun provideCurrencyRepository(currencyApi: CurrencyApi): CurrencyRepository {
        return CurrenciesRepositoryImpl(currencyApi)
    }

    @Provides
    @Singleton
    fun provideGetCurrenciesUserCase(currencyRepository: CurrencyRepository): GetCurrenciesUseCase =
        GetCurrenciesUseCase(currencyRepository)

    @Provides
    @Singleton
    fun provideGetLatestRateUseCase(currencyRepository: CurrencyRepository): GetLatestRatesUseCase =
        GetLatestRatesUseCase(currencyRepository)

}