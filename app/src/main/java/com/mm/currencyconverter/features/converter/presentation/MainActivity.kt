package com.mm.currencyconverter.features.converter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mm.currencyconverter.features.converter.presentation.screens.dashboard.Dashboard
import com.mm.currencyconverter.features.converter.presentation.screens.splash.SplashScreen
import com.mm.currencyconverter.features.converter.presentation.ui.theme.CurrencyConverterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CurrencyConverterTheme {
                NavHost(navController = navController, startDestination = "SplashScreen") {
                    composable("SplashScreen") { SplashScreen(navController) }
                    composable("Dashboard") { Dashboard() }
                }
            }
        }
    }
}