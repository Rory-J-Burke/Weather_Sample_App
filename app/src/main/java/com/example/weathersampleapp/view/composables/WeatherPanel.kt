package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.model.dto.GeocodingResponse
import com.example.weathersampleapp.view.DUMMY_CURRENT_WEATHER

@Composable
fun WeatherPanel(
    navController: NavHostController,
    searchFieldValue: String = "",
    cw: CurrentWeatherResponse = DUMMY_CURRENT_WEATHER,
    lf: List<ForecastDay> = listOf(),
    lg: List<GeocodingResponse> = listOf(),
    updateSearchFieldValue: (s: String) -> Unit,
    searchBoxTrigger: () -> Unit,
    rowSelectTrigger: (d: ForecastDay) -> Unit,
    geocodingSelectTrigger: (it: GeocodingResponse) -> Unit
){
    Column {
        WeatherSearchBar(
            navController,
            searchFieldValue,
            lg,
            updateSearchFieldValue,
            searchBoxTrigger,
            geocodingSelectTrigger
        )
        CurrentWeatherPanel(cw)
        DailyForecastPanel(navController, lf, rowSelectTrigger)
        WindCard(cw.wind)
    }
}