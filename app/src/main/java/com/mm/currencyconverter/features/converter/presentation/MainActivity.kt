package com.mm.currencyconverter.features.converter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.Dashboard
import com.mm.currencyconverter.features.converter.presentation.ui.theme.CurrencyConverterTheme
import com.mm.currencyconverter.features.converter.presentation.viewmodels.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                Dashboard(viewModel)
            }
        }
    }
}