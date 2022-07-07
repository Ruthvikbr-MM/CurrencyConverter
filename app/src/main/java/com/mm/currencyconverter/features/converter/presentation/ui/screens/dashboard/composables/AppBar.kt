package com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mm.currencyconverter.R

@Composable
fun AppBar(
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
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.fillMaxWidth(0.1f)
        )
        Text(
            text = stringResource(id = R.string.app_bar_title),
            modifier = Modifier.fillMaxWidth(0.9f),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}