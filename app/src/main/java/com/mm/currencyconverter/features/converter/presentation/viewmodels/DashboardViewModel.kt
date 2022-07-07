package com.mm.currencyconverter.features.converter.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mm.domain.use_cases.GetCurrenciesUseCase
import com.mm.domain.use_cases.GetLatestRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val getLatestRatesUseCase: GetLatestRatesUseCase,
) : ViewModel() {

    var uiState = MutableStateFlow<UiState>(UiState.Loading)
        private set
    var currencySymbols = MutableStateFlow(emptyList<String>())
    var primaryCurrency = MutableStateFlow("")
    var secondaryCurrency = MutableStateFlow("")
    val conversionFactor = MutableStateFlow(0.0)


    suspend fun getCurrencies() {
        val currencies = getCurrenciesUseCase.getCurrencies()
        if (currencies.isNotEmpty()) {
            currencySymbols.value = currencies.keys.toList()
            primaryCurrency.value = currencies.keys.toList().random()
            secondaryCurrency.value = currencies.keys.toList().random()
            getLatestRates(primaryCurrency.value, secondaryCurrency.value)

        } else {
            uiState.value = UiState.Error
        }
    }

    fun updatePrimaryCurrency(selectedCurrency: String) {
        primaryCurrency.value = selectedCurrency
        CoroutineScope(Dispatchers.IO).launch {
            getLatestRates(selectedCurrency, secondaryCurrency.value)
        }

    }

    fun updateSecondaryCurrency(selectedCurrency: String) {
        secondaryCurrency.value = selectedCurrency
        CoroutineScope(Dispatchers.IO).launch {
            getLatestRates(primaryCurrency.value, selectedCurrency)
        }
    }

    private suspend fun getLatestRates(baseCurrency: String, conversionCurrency: String) {

        val cFactor = getLatestRatesUseCase.getLatestRate(baseCurrency, conversionCurrency)
        Log.v("ATGS", "$baseCurrency , $conversionCurrency , $cFactor")
        conversionFactor.value = cFactor ?: 0.0
        uiState.value =
            UiState.Success
    }

    fun switchCurrency(selectedCurrency: String, conversionCurrency: String, cFactor: Double) {
        primaryCurrency.value = conversionCurrency
        secondaryCurrency.value = selectedCurrency
        conversionFactor.value = 1 / cFactor
    }

    sealed class UiState {
        object Loading : UiState()
        object Success : UiState()
        object Error : UiState()
    }
}