package com.example.weathersampleapp.view

import com.example.weathersampleapp.model.dto.Clouds
import com.example.weathersampleapp.model.dto.Coordinates
import com.example.weathersampleapp.model.dto.CurrentSys
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.model.dto.FeelsLike
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.model.dto.Main
import com.example.weathersampleapp.model.dto.Temp
import com.example.weathersampleapp.model.dto.Wind
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

val DUMMY_CURRENT_WEATHER = CurrentWeatherResponse(
    Coordinates(0.0, 0.0),
    listOf(),
    "N/A",
    Main(
        Double.NaN,
        Double.NaN,
        Double.NaN,
        Double.NaN,
        Double.NaN,
        Double.NaN,
        Double.NaN,
        Double.NaN,
    ),
    0L,
    Wind(Double.NaN, -1, Double.NaN),
    null,
    null,
    Clouds(Double.NaN),
    0L,
    CurrentSys(-1, 0L, "N/A", 0L, 0L),
    0L,
    0L,
    "N/A",
    0L,
)

val DUMMY_FORECAST_DAY = ForecastDay(
    0L,
    0L,
    0L,
    Temp(
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
    ),
    FeelsLike(
        0.0,
        0.0,
        0.0,
        0.0,
    ),
    0.0,
    0.0,
    listOf(),
    0.0,
    -1,
    0.0,
    0.0,
    0.0,
    0.0,
)

fun timestamp(
    l: Long
) = Instant.fromEpochMilliseconds(l).toLocalDateTime(
    TimeZone.currentSystemDefault()
).toString()