package com.example.weathersampleapp.model

import android.util.Log
import android.widget.Toast
import com.example.weathersampleapp.WeatherSampleApp
import com.example.weathersampleapp.model.api.OpenWeatherMapAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

private const val TAG = "WeatherRepository"

class WeatherRepository private constructor() : CoroutineScope  {
    //singleton implementation boiler-plate
    companion object {
        @Volatile
        private var instance: WeatherRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: WeatherRepository().also { instance = it }
            }
    }
    //

    //Coroutine scope boiler-plate
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
    //

    //back-end accessors
    private val openWeatherMapAPI = OpenWeatherMapAPI.initRetrofit()
    //

    //util functions
    private fun <T> handleResponse(
        op: Response<T>,
        errorMessage: String
    ) = op.let{
        try {
            if (it.isSuccessful) it.body()
            else null.also{
                Log.d(TAG, "Non-Exception Failure!")
                //Here we would log to other logging services
                //Splunk, Crashlytics, etc.
                Toast.makeText(
                    WeatherSampleApp.weatherContext,
                    errorMessage,
                    Toast.LENGTH_SHORT
                )
            }
        } catch (e: HttpException) {
            null.also{
                Toast.makeText(
                    WeatherSampleApp.weatherContext,
                    "Exception ${e.message}",
                    Toast.LENGTH_SHORT
                )
            }
        } catch (e: Throwable) {
            null.also{
                Log.d(TAG, "Non-Exception Failure!")
                Toast.makeText(
                    WeatherSampleApp.weatherContext,
                    errorMessage,
                    Toast.LENGTH_SHORT
                )
            }
        }
    }
    //

    //wrapper functions
    suspend fun directGeocoding(
        q: String
    ) = handleResponse(
        openWeatherMapAPI.directGeocoding(q),
        "Failed to load Geocoding data from the network."
    )


    suspend fun zipGeocoding(
        q: String
    ) = handleResponse(
        openWeatherMapAPI.zipGeocoding(q),
        "Failed to load Geocoding data from the network."
    )

    suspend fun reverseGeocoding(
        lat: Double,
        lon: Double
    ) = handleResponse(
        openWeatherMapAPI.reverseGeocoding(lat, lon),
        "Failed to load Geocoding data from the network."
    )

    suspend fun currentWeather(
        lat: Double,
        lon: Double
    ) = handleResponse(
        openWeatherMapAPI.currentWeather(lat, lon),
        "Failed to load Weather data from the network."
    )

    suspend fun dailyForecast(
        lat: Double,
        lon: Double
    ) = handleResponse(
        openWeatherMapAPI.dailyForecast(lat, lon),
        "Failed to load Forecast data from the network."
    )
    //
}
