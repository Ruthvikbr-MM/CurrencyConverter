package com.mm.currencyconverter.features.converter.presentation.utils

import kotlin.math.round

object Converter {
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}