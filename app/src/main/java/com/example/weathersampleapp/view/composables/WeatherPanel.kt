package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.view.DUMMY_CURRENT_WEATHER

@Composable
fun WeatherPanel(
    navController: NavHostController,
    searchFieldValue: String = "",
    cw: CurrentWeatherResponse = DUMMY_CURRENT_WEATHER,
    l: List<ForecastDay> = listOf(),
    updateSearchFieldValue: (s: String) -> Unit,
    searchBoxTrigger: () -> Unit,
    rowSelectTrigger: (d: ForecastDay) -> Unit
){
    Column {
        WeatherSearchBar(searchFieldValue, updateSearchFieldValue, searchBoxTrigger)
        CurrentWeatherPanel(cw)
        DailyForecastPanel(navController, l, rowSelectTrigger)
        WindCard(cw.wind)
    }
}