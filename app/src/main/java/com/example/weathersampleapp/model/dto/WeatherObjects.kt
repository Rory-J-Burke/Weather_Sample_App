package com.example.weathersampleapp.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("lon")
    val lon: Double,

    @SerialName("lat")
    val lat: Double,
)

@Serializable
data class Weather(
    @SerialName("id")
    val id: Int,

    @SerialName("main")
    val main: String,

    @SerialName("description")
    val description: String,

    @SerialName("icon")
    val icon: String,
)

@Serializable
data class Main(
    @SerialName("temp")
    val temp: Double,

    @SerialName("feels_like")
    val feelsLike: Double,

    @SerialName("temp_min")
    val tempMin: Double,

    @SerialName("temp_max")
    val tempMax: Double,

    @SerialName("pressure")
    val pressure: Double,

    @SerialName("humidity")
    val humidity: Double,

    @SerialName("sea_level")
    val seaLevel: Double,

    @SerialName("grnd_level")
    val groundLevel: Double,
)

@Serializable
data class Wind(
    @SerialName("speed")
    val speed: Double,

    @SerialName("deg")
    val deg: Int,

    @SerialName("gust")
    val gust: Double? = null,
)

@Serializable
data class Precipitation(
    @SerialName("1h")
    val oneHour: Double,
)

@Serializable
data class Clouds(
    @SerialName("all")
    val all: Double,
)

@Serializable
data class CurrentSys(
    @SerialName("type")
    val type: Int,

    @SerialName("id")
    val id: Long,

    @SerialName("country")
    val country: String,

    @SerialName("sunrise")
    val sunrise: Long,

    @SerialName("sunset")
    val sunset: Long,
)

@Serializable
data class CurrentWeatherResponse(
    @SerialName("coord")
    val coord: Coordinates,

    @SerialName("weather")
    val weather: List<Weather>,

    @SerialName("base")
    val base: String,

    @SerialName("main")
    val main: Main,

    @SerialName("visibility")
    val visibility: Long,

    @SerialName("wind")
    val wind: Wind,

    @SerialName("rain")
    val rain: Precipitation? = null,

    @SerialName("snow")
    val snow: Precipitation? = null,

    @SerialName("clouds")
    val clouds: Clouds,

    @SerialName("dt")
    val dt: Long,

    @SerialName("sys")
    val sys: CurrentSys,

    @SerialName("timezone")
    val timezone: Long,

    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("cod")
    val cod: Long,
)

//@Serializable
//data class HourForecastSys(
//    @SerialName("pod")
//    val pod: String,
//)

//@Serializable
//data class ForecastHour(
//    @SerialName("dt")
//    val dt: Long,
//
//    @SerialName("main")
//    val main: Main,
//
//    @SerialName("weather")
//    val weather: List<Weather>,
//
//    @SerialName("clouds")
//    val clouds: Clouds,
//
//    @SerialName("wind")
//    val wind: Wind,
//
//    @SerialName("rain")
//    val rain: Precipitation? = null,
//
//    @SerialName("snow")
//    val snow: Precipitation? = null,
//
//    @SerialName("visibility")
//    val visibility: Int,
//
//    @SerialName("pop")
//    val pop: Double,
//
//    @SerialName("sys")
//    val sys: HourForecastSys,
//
//    @SerialName("dt_txt")
//    val dtText: String,
//)

//@Serializable
//data class HourlyCity(
//    @SerialName("id")
//    val id: Long,
//
//    @SerialName("name")
//    val name: String,
//
//    @SerialName("coord")
//    val coordinates: Coordinates,
//
//    @SerialName("country")
//    val country: String,
//
//    @SerialName("population")
//    val population: Int,
//
//    @SerialName("timezone")
//    val timezone: Long,
//
//    @SerialName("sunrise")
//    val sunrise: Long,
//
//    @SerialName("sunset")
//    val sunset: Long,
//)

//@Serializable
//data class HourlyForecastResponse(
//    @SerialName("cod")
//    val cod: String,
//
//    @SerialName("message")
//    val message: Double,
//
//    @SerialName("cnt")
//    val cnt: Int,
//
//    @SerialName("list")
//    val list: List<ForecastHour>,
//
//    @SerialName("city")
//    val city: HourlyCity,
//)

@Serializable
data class DailyCity(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("coord")
    val coordinates: Coordinates,

    @SerialName("country")
    val country: String,

    @SerialName("population")
    val population: Int,

    @SerialName("timezone")
    val timezone: Long,
)

@Serializable
data class Temp(
    @SerialName("day")
    val day: Double,

    @SerialName("min")
    val min: Double,

    @SerialName("max")
    val max: Double,

    @SerialName("night")
    val night: Double,

    @SerialName("eve")
    val eve: Double,

    @SerialName("morn")
    val morn: Double,
)

@Serializable
data class FeelsLike(
    @SerialName("day")
    val day: Double,

    @SerialName("night")
    val night: Double,

    @SerialName("eve")
    val eve: Double,

    @SerialName("morn")
    val morn: Double,
)

@Serializable
data class ForecastDay(
    @SerialName("dt")
    val dt: Long,

    @SerialName("sunrise")
    val sunrise: Long,

    @SerialName("sunset")
    val sunset: Long,

    @SerialName("temp")
    val temp: Temp,

    @SerialName("feels_like")
    val feelsLike: FeelsLike,

    @SerialName("pressure")
    val pressure: Double,

    @SerialName("humidity")
    val humidity: Double,

    @SerialName("weather")
    val weather: List<Weather>,

    @SerialName("speed")
    val speed: Double,

    @SerialName("deg")
    val deg: Int,

    @SerialName("gust")
    val gust: Double? = null,

    @SerialName("clouds")
    val clouds: Double,

    @SerialName("pop")
    val pop: Double,

    @SerialName("rain")
    val rain: Double,
)

@Serializable
data class DailyForecastResponse(
    @SerialName("city")
    val city: DailyCity,

    @SerialName("cod")
    val cod: String,

    @SerialName("message")
    val message: Double,

    @SerialName("cnt")
    val cnt: Int,

    @SerialName("list")
    val list: List<ForecastDay>,
)
