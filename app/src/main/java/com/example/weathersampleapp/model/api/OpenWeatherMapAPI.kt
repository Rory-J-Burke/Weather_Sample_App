package com.example.weathersampleapp.model.api

import com.example.weathersampleapp.model.API_KEY
import com.example.weathersampleapp.model.BASE_URL
import com.example.weathersampleapp.model.CURRENT_WEATHER_ENDPOINT
import com.example.weathersampleapp.model.DAILY_FORECAST_ENDPOINT
import com.example.weathersampleapp.model.DIRECT_GEOCODING_ENDPOINT
import com.example.weathersampleapp.model.REVERSE_GEOCODING_ENDPOINT
import com.example.weathersampleapp.model.ZIP_GEOCODING_ENDPOINT
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.model.dto.DailyForecastResponse
import com.example.weathersampleapp.model.dto.GeocodingResponse
import com.example.weathersampleapp.model.dto.ZipGeocodingResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapAPI{
    companion object{
        fun initRetrofit(): OpenWeatherMapAPI = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json{
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(OpenWeatherMapAPI::class.java)
    }

    @GET(DIRECT_GEOCODING_ENDPOINT)
    suspend fun directGeocoding(
        @Query("q")
        q: String,

        @Query("appId")
        appId: String = API_KEY,

        @Query("limit")
        limit: Int = 10
    ): Response<List<GeocodingResponse>>

    @GET(ZIP_GEOCODING_ENDPOINT)
    suspend fun zipGeocoding(
        @Query("q")
        q: String,

        @Query("appId")
        appId: String = API_KEY,
    ): Response<ZipGeocodingResponse>

    @GET(REVERSE_GEOCODING_ENDPOINT)
    suspend fun reverseGeocoding(
        @Query("lat")
        lat: Double,

        @Query("lon")
        lon: Double,

        @Query("appId")
        appId: String = API_KEY,

        @Query("limit")
        limit: Int = 10
    ): Response<List<GeocodingResponse>>

    @GET(CURRENT_WEATHER_ENDPOINT)
    suspend fun currentWeather(
        @Query("lat")
        lat: Double,

        @Query("lon")
        lon: Double,

        @Query("appId")
        appId: String = API_KEY,

        @Query("units")
        units: String = "imperial",

        @Query("lang")
        lang: String = "en",
    ): Response<CurrentWeatherResponse>

    @GET(DAILY_FORECAST_ENDPOINT)
    suspend fun dailyForecast(
        @Query("lat")
        lat: Double,

        @Query("lon")
        lon: Double,

        @Query("appId")
        appId: String = API_KEY,

        @Query("cnt")
        count: Int = 7,

        @Query("units")
        units: String = "imperial",

        @Query("lang")
        lang: String = "en",
    ): Response<DailyForecastResponse>
}