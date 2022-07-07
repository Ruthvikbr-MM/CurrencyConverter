package com.mm.domain

interface CurrencyRepository {
    suspend fun getCurrencies(): Map<String, String>
    suspend fun getLatestRates(base: String): Map<String, Double>?
}