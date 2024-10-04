package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.weathersampleapp.model.dto.GeocodingResponse
import com.example.weathersampleapp.view.NavigationItem

@Composable
fun GeocodingResultList(
    navController: NavHostController,
    l: List<GeocodingResponse>,
    geocodingSelectTrigger: (it: GeocodingResponse) -> Unit
){
    LazyColumn {
        items(l){
            Row(
                modifier = Modifier.clickable {
                    geocodingSelectTrigger(it)
                    navController.navigate(NavigationItem.ForecastDayDetail.route)
                }
            ) {
                GeocodingResultRow(it)
            }
        }
    }
}