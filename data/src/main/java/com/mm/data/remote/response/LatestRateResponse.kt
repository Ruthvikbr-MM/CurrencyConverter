package com.mm.data.remote.response

data class LatestRateResponse(
    val base: String? = null,
    val disclaimer: String? = null,
    val license: String? = null,
    val rates: Map<String, Double>? = null,
    val timestamp: Long? = null
)
