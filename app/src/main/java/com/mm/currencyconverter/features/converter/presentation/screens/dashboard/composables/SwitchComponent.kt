package com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.ui.theme.grey
import com.mm.currencyconverter.features.converter.presentation.ui.theme.poppins

@Composable
fun SwitchComponent(
    primaryConversionUnit: String,
    secondaryConversionUnit: String,
    conversionRate: Float
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
            contentDescription = stringResource(id = R.string.flip_currency_description),
            tint = Color.White,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(grey)
                .padding(8.dp)
                .clickable {

                }
        )
        Text(
            text = "1 $primaryConversionUnit = $conversionRate $secondaryConversionUnit",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.DarkGray)
                .padding(16.dp)
        )
    }
}