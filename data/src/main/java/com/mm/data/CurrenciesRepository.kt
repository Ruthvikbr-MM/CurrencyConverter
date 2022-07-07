package com.mm.data

import com.mm.data.remote.CurrencyApi
import com.mm.data.remote.utils.Constants.APP_ID
import com.mm.domain.CurrencyRepository
import javax.inject.Inject

class CurrenciesRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi,
) : CurrencyRepository {
    override suspend fun getCurrencies(): Map<String, String> {
        return currencyApi.fetchCurrencies(APP_ID)
    }

    override suspend fun getLatestRates(base: String): Map<String, Double>? {
        return currencyApi.getLatestRates(APP_ID, base).rates
    }

}