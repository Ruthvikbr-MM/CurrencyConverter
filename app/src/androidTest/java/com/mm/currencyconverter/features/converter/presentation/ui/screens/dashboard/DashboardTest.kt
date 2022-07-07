package com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mm.currencyconverter.FakeCurrencyApi
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.ui.theme.CurrencyConverterTheme
import com.mm.currencyconverter.features.converter.presentation.viewmodels.DashboardViewModel
import com.mm.data.CurrenciesRepositoryImpl
import com.mm.domain.use_cases.GetCurrenciesUseCase
import com.mm.domain.use_cases.GetLatestRatesUseCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardTest {

    private var currencyApi = FakeCurrencyApi()

    private val currencyRepository by lazy {
        CurrenciesRepositoryImpl(currencyApi)
    }

    private val getCurrenciesUseCase by lazy {
        GetCurrenciesUseCase(currencyRepository)
    }

    private val getLatestRatesUseCase by lazy {
        GetLatestRatesUseCase(currencyRepository)
    }

    private lateinit var dashboardViewModel: DashboardViewModel

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testUI() {
        dashboardViewModel = DashboardViewModel(
            getCurrenciesUseCase, getLatestRatesUseCase
        )

        composeTestRule.setContent {
            CurrencyConverterTheme {
                Dashboard(viewModel = dashboardViewModel)
            }
        }

        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.secondary_currency_text_field_content_description))
            .assertIsDisplayed()

    }

}