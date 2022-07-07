package com.mm.domain.use_cases

import com.mm.domain.CurrencyRepository

class GetLatestRatesUseCase(private val currencyRepository: CurrencyRepository) {
    suspend fun getLatestRate(base: String, conversionCurrency: String): Double? {
        val map = currencyRepository.getLatestRates(base)

        return map?.get(conversionCurrency)
    }
}