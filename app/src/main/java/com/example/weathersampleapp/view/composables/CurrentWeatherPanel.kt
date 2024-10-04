package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse
import com.example.weathersampleapp.view.DUMMY_CURRENT_WEATHER
import com.example.weathersampleapp.view.timestamp

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CurrentWeatherPanel(
    cw: CurrentWeatherResponse
){
    Column {
        Text(text = cw.weather[0].description)
        GlideImage(
            model = "https://openweathermap.org/img/wn/${cw.weather[0].icon}@2x.png",
            contentDescription = cw.weather[0].description,
            loading = placeholder(ColorPainter(Color.Gray)),
            failure = placeholder(ColorPainter(Color.Black)),
            modifier = Modifier
        )

        Text(text = "${cw.main.temp}")
        Text(text = "Feels like ${cw.main.feelsLike}")
        Text(text = "Low: ${cw.main.tempMin} * High: ${cw.main.tempMax}")
        Text(text = "Pressure: ${cw.main.pressure}")
        Text(text = "Humidity: ${cw.main.humidity}")

        cw.rain?.oneHour?.let{
            Text(text = "Rain: $it mm/hr")
        }
        cw.snow?.oneHour?.let{
            Text(text = "Snow: $it mm/hr")
        }

        Text(text = timestamp(cw.dt))

        Text(text = "Sunrise: ${timestamp(cw.sys.sunrise)}")
        Text(text = "Sunset: ${timestamp(cw.sys.sunset)}")


        Text(text = cw.name)
    }
}

@Preview
@Composable
fun CurrentWeatherPanelPreview(
    cw: CurrentWeatherResponse = DUMMY_CURRENT_WEATHER
){
    CurrentWeatherPanel(cw)
}
