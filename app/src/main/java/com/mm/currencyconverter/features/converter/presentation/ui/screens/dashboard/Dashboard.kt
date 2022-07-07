package com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables.AppBar
import com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables.CurrencyComponent
import com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables.SwitchComponent
import com.mm.currencyconverter.features.converter.presentation.viewmodels.DashboardViewModel
import kotlinx.coroutines.launch

@Composable
fun Dashboard(
    viewModel: DashboardViewModel
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            viewModel.getCurrencies()
        }
    }

    val loadingState by viewModel.uiState.collectAsState()

    val currencySymbols by viewModel.currencySymbols.collectAsState()

    val primaryCurrency by viewModel.primaryCurrency.collectAsState()

    val secondaryCurrency by viewModel.secondaryCurrency.collectAsState()

    val conversionFactor by viewModel.conversionFactor.collectAsState()

    var primaryCurrencyInputValue = remember {
        mutableStateOf(0.0)
    }
    var secondaryCurrencyInputValue = remember {
        mutableStateOf(0.0)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        AppBar(
            backgroundColor = MaterialTheme.colorScheme.primary
        )
        if (loadingState == DashboardViewModel.UiState.Loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }
        } else {
            CurrencyComponent(
                currencies = currencySymbols,
                selectedLabel = primaryCurrency,
                onItemSelect = {
                    viewModel.updatePrimaryCurrency(it)
                },
                onInputValueChange = {
                    primaryCurrencyInputValue.value = it
                    secondaryCurrencyInputValue.value =
                        primaryCurrencyInputValue.value * conversionFactor
                },
                currencyInputValue = primaryCurrencyInputValue.value,
                contentDescription = stringResource(id = R.string.primary_currency_text_field_content_description),
                amountInputContentDescriptionn = stringResource(id = R.string.primary_currency_input_text_field_content_description)
            )
            SwitchComponent(
                primaryConversionUnit = primaryCurrency,
                secondaryConversionUnit = secondaryCurrency,
                conversionRate = conversionFactor,
                onClick = {
                    viewModel.switchCurrency(primaryCurrency, secondaryCurrency, conversionFactor)
                }
            )
            CurrencyComponent(
                shape = RoundedCornerShape(36.dp),
                currencies = currencySymbols,
                selectedLabel = secondaryCurrency,
                onItemSelect = {
                    viewModel.updateSecondaryCurrency(it)
                },
                onInputValueChange = {
                    secondaryCurrencyInputValue.value = it
                    primaryCurrencyInputValue.value =
                        secondaryCurrencyInputValue.value * (1 / conversionFactor)
                },
                currencyInputValue = secondaryCurrencyInputValue.value,
                contentDescription = stringResource(id = R.string.secondary_currency_text_field_content_description),
                amountInputContentDescriptionn = stringResource(id = R.string.secondary_currency_input_text_field_content_description)
            )
        }
    }

}