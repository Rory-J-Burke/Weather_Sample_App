package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.view.NavigationItem

@Composable
fun DailyForecastPanel(
    navController: NavHostController,
    l: List<ForecastDay>,
    rowSelectTrigger: (d: ForecastDay) -> Unit
){
    if(l.isEmpty()){
        Text(text = "Forecast Data Unavailable")
    }
    else{
        Column {
            l.forEach {
                Row(
                    modifier = Modifier
                        .clickable {
                            rowSelectTrigger(it)
                            navController.navigate(NavigationItem.ForecastDayDetail.route)
                        }
                        .padding(10.dp)
                ) { DailyForecastRow(it) }
            }
        }
    }
}