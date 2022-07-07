package com.mm.data.remote

import com.mm.data.remote.response.LatestRateResponse
import com.mm.data.remote.utils.Endpoints.GET_CURRENCIES
import com.mm.data.remote.utils.Endpoints.LATEST_CURRENCIES
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET(GET_CURRENCIES)
    suspend fun fetchCurrencies(@Query("app_id") appId: String): Map<String, String>

    @GET(LATEST_CURRENCIES)
    suspend fun getLatestRates(
        @Query("app_id") appId: String,
        @Query("Base") base: String
    ): LatestRateResponse


}