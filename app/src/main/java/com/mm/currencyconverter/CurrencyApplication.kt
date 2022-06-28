package com.mm.currencyconverter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CurrencyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}