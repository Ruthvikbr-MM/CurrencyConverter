package com.mm.currencyconverter.features.converter.presentation.screens.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.mm.currencyconverter.features.converter.presentation.ui.theme.grey
import com.mm.currencyconverter.features.converter.presentation.ui.theme.poppins

@Preview
@Composable
fun CurrencyComponent(
    shape: RoundedCornerShape = RoundedCornerShape(bottomEnd = 36.dp, bottomStart = 36.dp)
) {

    var expanded by remember { mutableStateOf(false) }
    val currencies = listOf("USD", "INR", "EUR")
    var selectedItem by remember { mutableStateOf("USD") }
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
            .background(grey)
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
                value = selectedItem,
                onValueChange = { },
                modifier = Modifier
                    .wrapContentWidth()
                    .background(grey)
                    .wrapContentHeight()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                enabled = false,
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppins
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = grey,

                    ),
                trailingIcon = {
                    Icon(
                        icon, "contentDescription",
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
                        selectedItem = item
                        expanded = false
                    }) {
                        Text(
                            text = item, style = TextStyle(
                                fontSize = 12.sp,
                                color = Color.Black,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
            }
        }
        Text(
            text = "0", style = TextStyle(
                fontSize = 48.sp,
                color = Color.DarkGray,
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold
            )
        )

    }
}