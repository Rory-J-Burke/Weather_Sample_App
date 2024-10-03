package com.example.weathersampleapp.model

//This is obviously insecure.  Only doing this because it is free public API.
//Optimally, you would fetch this from a "Secure Credential Vault" server,
// in your back-end, over an encrypted connection.
const val API_KEY = "fdd195d3e49924a0ca10cd9937957703"

const val BASE_URL = "https://api.openweathermap.org/"

const val DIRECT_GEOCODING_ENDPOINT = "geo/1.0/direct"

const val ZIP_GEOCODING_ENDPOINT = "geo/1.0/zip"

const val REVERSE_GEOCODING_ENDPOINT = "geo/1.0/reverse"

const val CURRENT_WEATHER_ENDPOINT = "data/2.5/weather"

const val DAILY_FORECAST_ENDPOINT = "data/2.5/forecast/daily"

//I'd like to include this data, but it is behind a paywall.
//const val HOURLY_FORECAST_ENDPOINT = "data/2.5/forecast/hourly"
