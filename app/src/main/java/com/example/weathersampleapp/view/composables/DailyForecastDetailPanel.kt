package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.model.dto.Wind
import com.example.weathersampleapp.view.DUMMY_FORECAST_DAY
import com.example.weathersampleapp.view.timestamp

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DailyForecastDetailPanel(
    d: ForecastDay = DUMMY_FORECAST_DAY
){
    Column {
        Text(text = timestamp(d.dt))
        GlideImage(
            model = "https://openweathermap.org/img/wn/${d.weather[0].icon}@2x.png",
            contentDescription = d.weather[0].description,
            loading = placeholder(ColorPainter(Color.Gray)),
            failure = placeholder(ColorPainter(Color.Black)),
            modifier = Modifier
        )
        Text(text = "${d.temp.max} / ${d.temp.min}")

        WindCard(Wind(d.speed, d.deg, d.gust))
        Text(text = "Chance Precipitation: ${d.pop}%")
    }
}