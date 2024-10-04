package com.example.weathersampleapp.view.composables

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.weathersampleapp.model.dto.Weather

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WeatherCard(
    w: Weather,
    modifier: Modifier
){
    Card {
        Text(text = w.description)
        GlideImage(
            model = "https://openweathermap.org/img/wn/${w.icon}@2x.png",
            contentDescription = w.description,
            loading = placeholder(ColorPainter(Color.Gray)),
            failure = placeholder(ColorPainter(Color.Black)),
            modifier = Modifier
        )
    }
}