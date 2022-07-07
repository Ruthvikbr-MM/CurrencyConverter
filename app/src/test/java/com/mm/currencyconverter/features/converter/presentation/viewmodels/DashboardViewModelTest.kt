package com.mm.currencyconverter.features.converter.presentation.viewmodels

import app.cash.turbine.test
import com.mm.data.CurrenciesRepositoryImpl
import com.mm.data.remote.CurrencyApi
import com.mm.domain.use_cases.GetCurrenciesUseCase
import com.mm.domain.use_cases.GetLatestRatesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class DashboardViewModelTest {

    @MockK
    lateinit var currencyApi: CurrencyApi

    private val currencyRepository by lazy {
        CurrenciesRepositoryImpl(currencyApi)
    }

    private val getCurrenciesUseCase by lazy {
        GetCurrenciesUseCase(currencyRepository)
    }

    private val getLatestRatesUseCase by lazy {
        GetLatestRatesUseCase(currencyRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, true)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    private lateinit var dashboardViewModel: DashboardViewModel

    @Test
    fun getCurrenciesTest() {
        runTest {
            launch {
                coEvery {
                    currencyApi.fetchCurrencies("")
                } returns hashMapOf<String, String>().apply {
                    put("USD", "US Dollar")
                    put("INR", "Indian Rupees")
                }

                dashboardViewModel = DashboardViewModel(
                    getCurrenciesUseCase, getLatestRatesUseCase
                )

                dashboardViewModel.uiState.test {
                    assert(awaitItem() is DashboardViewModel.UiState.Loading)
                    val lastComplete = awaitItem()
                    assert(lastComplete is DashboardViewModel.UiState.Success)
                    awaitComplete()
                }
            }
        }
    }
}