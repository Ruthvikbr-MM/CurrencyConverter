package com.mm.currencyconverter.features.converter.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mm.currencyconverter.R

val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_extra_light, FontWeight.ExtraLight),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
    Font(R.font.poppins_thin, FontWeight.Thin),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontSize = 36.sp,
        color = Color.DarkGray,
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold
    ),
    bodyMedium = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontFamily = poppins,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        color = Color.Black,
        fontFamily = poppins,
        fontWeight = FontWeight.Normal
    ),
    displayMedium = TextStyle(
        fontSize = 24.sp,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppins
    ),
    displaySmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = poppins,
        fontWeight = FontWeight.Light,
        color = Color.LightGray,
        textAlign = TextAlign.Center
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)