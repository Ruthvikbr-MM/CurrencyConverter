package com.mm.currencyconverter

import com.mm.data.remote.CurrencyApi
import com.mm.data.remote.response.LatestRateResponse

class FakeCurrencyApi : CurrencyApi {
    override suspend fun fetchCurrencies(appId: String): Map<String, String> {
        return hashMapOf<String, String>().apply {
            put("INR", "Indian Rupee")
            put("USD", "US Dollars")
        }
    }

    override suspend fun getLatestRates(appId: String, base: String): LatestRateResponse {
        return LatestRateResponse("USD", rates = hashMapOf<String, Double>().apply {
            put("INR", 75.0)
            put("USD", 1.0)
        })
    }
}