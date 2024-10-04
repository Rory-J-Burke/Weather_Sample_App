package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathersampleapp.model.dto.GeocodingResponse

@Composable
fun GeocodingResultRow(
    g: GeocodingResponse
){
    Row {
        Text(
            text = "${g.name}, ${g.state?.let{"$it, "} ?: ""}${g.country}",
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = "lat ${g.lat}",
            modifier = Modifier.weight(0.25f)
        )
        Text(
            text = "lon ${g.lon}",
            modifier = Modifier.weight(0.25f)
        )
    }
}