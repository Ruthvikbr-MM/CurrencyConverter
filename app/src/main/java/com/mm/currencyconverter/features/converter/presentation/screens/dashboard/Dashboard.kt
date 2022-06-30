package com.mm.currencyconverter.features.converter.presentation.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables.AppBar
import com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables.CurrencyComponent
import com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables.SwitchComponent
import com.mm.currencyconverter.features.converter.presentation.ui.theme.grey

@Preview(showSystemUi = true)
@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        AppBar(
            textColor = Color.White,
            backgroundColor = grey
        )
        CurrencyComponent()
        SwitchComponent(primaryConversionUnit = "USD", "INR", 78.90f)
        CurrencyComponent(
            shape = RoundedCornerShape(36.dp)
        )
    }
}