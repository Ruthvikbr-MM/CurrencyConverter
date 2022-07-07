package com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.ui.theme.grey
import com.mm.currencyconverter.features.converter.presentation.utils.Converter.round

@Composable
fun SwitchComponent(
    primaryConversionUnit: String,
    secondaryConversionUnit: String,
    conversionRate: Double,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_sync_24),
            contentDescription = stringResource(id = R.string.flip_currency_button_description),
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(grey)
                .padding(8.dp)
                .clickable {
                    onClick()
                }
        )
        Text(
            text = "1 $primaryConversionUnit = ${conversionRate.round(2)} $secondaryConversionUnit",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.DarkGray)
                .padding(16.dp)
        )
    }
}