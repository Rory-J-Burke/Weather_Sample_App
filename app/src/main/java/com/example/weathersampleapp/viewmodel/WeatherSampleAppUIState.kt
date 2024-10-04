package com.example.weathersampleapp.viewmodel

import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.model.dto.GeocodingResponse
import com.example.weathersampleapp.view.DUMMY_CURRENT_WEATHER
import com.example.weathersampleapp.view.DUMMY_FORECAST_DAY

data class WeatherSampleAppUIState (
    val searchFieldValue: String = "",
    val isSearching: Boolean = false,
    val lg: List<GeocodingResponse>? = null,
    val cw: CurrentWeatherResponse = DUMMY_CURRENT_WEATHER,
    val lf: List<ForecastDay>? = null,
    val d: ForecastDay = DUMMY_FORECAST_DAY
)