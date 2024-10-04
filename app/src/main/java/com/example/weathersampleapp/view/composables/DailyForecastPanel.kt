package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.view.NavigationItem

@Composable
fun DailyForecastPanel(
    navController: NavHostController,
    l: List<ForecastDay>,
    rowSelectTrigger: (d: ForecastDay) -> Unit
){
    Column {
        l.forEach {
            Row(
                modifier = Modifier.clickable {
                    rowSelectTrigger(it)
                    navController.navigate(NavigationItem.ForecastDayDetail.route)
                }
            ) { DailyForecastRow(it) }
        }
    }
}