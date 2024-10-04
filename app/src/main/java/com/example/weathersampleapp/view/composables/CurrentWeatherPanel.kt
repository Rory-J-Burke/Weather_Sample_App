package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathersampleapp.model.dto.CurrentWeatherResponse

@Composable
fun CurrentWeatherPanel(
    cw: CurrentWeatherResponse
){
    Column {
        Card {
            Text(
                text = cw.name,
                modifier = Modifier
//                .weight(0.1f)
            )
            Text(
                text = "${cw.main.temp} F",
                modifier = Modifier
//                .weight(0.1f)
            )
            Text(
                text = "Feels like ${cw.main.feelsLike} F",
                modifier = Modifier
//                .weight(0.1f)
            )
            Text(
                text = "Low: ${cw.main.tempMin} F * High: ${cw.main.tempMax} F",
                modifier = Modifier
//                .weight(0.1f)
            )
            Text(
                text = "Humidity: ${cw.main.humidity}%",
                modifier = Modifier
//                .weight(0.1f)
            )
        }


        cw.weather.ifEmpty{ null }?.get(0)?.let{
            WeatherCard(
                it,
                modifier = Modifier
//                    .weight(0.3f)
            )
        }

//        Text(text = "Pressure: ${cw.main.pressure}")


        cw.rain?.oneHour?.let{
            Text(
                text = "Rain: $it mm/hr",
                modifier = Modifier
//                    .weight(0.1f)
            )
        }
        cw.snow?.oneHour?.let{
            Text(
                text = "Snow: $it mm/hr",
                modifier = Modifier
//                    .weight(0.1f)
            )
        }

//        Text(text = timestamp(cw.dt))


    }
}
