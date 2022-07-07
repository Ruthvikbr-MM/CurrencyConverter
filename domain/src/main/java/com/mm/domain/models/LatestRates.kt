package com.mm.domain.models

data class LatestRates(val name: String, val rate: Double, val currency: String) {
    fun calculateRate(amount: Double) = rate * amount
}