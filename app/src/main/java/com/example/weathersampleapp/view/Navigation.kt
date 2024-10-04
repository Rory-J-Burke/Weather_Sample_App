package com.example.weathersampleapp.view

enum class Screen {
    CURRENT,
    FORECAST_DAY_DETAIL,
}

sealed class NavigationItem(val route: String) {
    data object Current : NavigationItem(Screen.CURRENT.name)
    data object ForecastDayDetail : NavigationItem(Screen.FORECAST_DAY_DETAIL.name)
}
