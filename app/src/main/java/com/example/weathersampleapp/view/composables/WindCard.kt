package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathersampleapp.model.dto.Wind

@Composable
fun WindCard(
    w: Wind
){
    Card {
        Column {
            Text(text = "Wind")
            Text(text = "${w.speed} mph")
            Text(text = "From: ${w.deg}")
            Text(text = "Gusting: ${w.gust}")
        }
    }
}

@Preview
@Composable
fun WindCardPreview(
    w: Wind = Wind(0.0, -1, 0.0)
){
    WindCard(w)
}