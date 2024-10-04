package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersampleapp.model.dto.GeocodingResponse

@Composable
fun GeocodingResultList(
    l: List<GeocodingResponse>,
    geocodingSelectTrigger: (it: GeocodingResponse) -> Unit
){
    LazyColumn {
        items(l){
            Row(
                modifier = Modifier
                    .clickable {
                        geocodingSelectTrigger(it)
                    }.padding(10.dp)
            ) {
                GeocodingResultRow(it)
            }
        }
    }
}