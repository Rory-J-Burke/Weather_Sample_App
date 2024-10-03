package com.example.weathersampleapp

import android.app.Application
import android.content.Context

class WeatherSampleApp: Application() {
    companion object{
        lateinit var weatherContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        weatherContext = applicationContext
    }
}