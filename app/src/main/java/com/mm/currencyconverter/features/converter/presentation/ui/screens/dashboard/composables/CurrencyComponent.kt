package com.mm.currencyconverter.features.converter.presentation.ui.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.mm.currencyconverter.R
import com.mm.currencyconverter.features.converter.presentation.utils.Converter.round

@Composable
fun CurrencyComponent(
    shape: RoundedCornerShape = RoundedCornerShape(bottomEnd = 36.dp, bottomStart = 36.dp),
    currencies: List<String>,
    selectedLabel: String,
    onItemSelect: (label: String) -> Unit,
    currencyInputValue: Double,
    onInputValueChange: (value: Double) -> Unit,
    contentDescription: String,
    amountInputContentDescriptionn: String
) {

    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Default.KeyboardArrowUp
    } else {
        Icons.Default.KeyboardArrowDown
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = selectedLabel,
                onValueChange = { },
                modifier = Modifier
                    .wrapContentWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .wrapContentHeight()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    }
                    .semantics {
                        this.contentDescription = contentDescription
                    },
                enabled = false,
                textStyle = MaterialTheme.typography.displayMedium,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colorScheme.primary,

                    ),
                trailingIcon = {
                    Icon(
                        icon, stringResource(id = R.string.currency_dropdown_description),
                        Modifier
                            .size(24.dp)
                            .clickable { expanded = !expanded },
                        tint = Color.LightGray
                    )
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(with(LocalDensity.current) {
                    textFieldSize.width.toDp()
                })
            ) {
                currencies.forEachIndexed { _, item ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        onItemSelect(item)
                    }) {
                        Text(
                            text = item, style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
        TextField(
            value = if (currencyInputValue == 0.0) {
                ""
            } else {
                "${currencyInputValue.round(2)}"
            },
            onValueChange = {
                try {
                    onInputValueChange(it.toDouble())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .semantics {
                    this.contentDescription = ""
                },
            textStyle = MaterialTheme.typography.bodyLarge,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal)
        )

    }
}