package com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.ui.theme.poppins

@Composable
fun AppBar(
    textColor: Color,
    backgroundColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = stringResource(id = R.string.app_bar_title_description),
            tint = Color.White,
            modifier = Modifier.fillMaxWidth(0.1f)
        )
        Text(
            text = stringResource(id = R.string.app_bar_title),
            modifier = Modifier.fillMaxWidth(0.9f),
            style = TextStyle(
                color = textColor,
                fontSize = 16.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        )
    }
}