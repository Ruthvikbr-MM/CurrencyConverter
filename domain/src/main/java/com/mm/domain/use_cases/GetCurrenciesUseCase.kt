package com.mm.domain.use_cases

import com.mm.domain.CurrencyRepository

class GetCurrenciesUseCase(private val currencyRepository: CurrencyRepository) {
    suspend fun getCurrencies(): Map<String, String> {
        return currencyRepository.getCurrencies()
    }
}