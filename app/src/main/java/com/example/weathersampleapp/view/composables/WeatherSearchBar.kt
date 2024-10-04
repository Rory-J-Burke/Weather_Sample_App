package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.weathersampleapp.model.dto.GeocodingResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherSearchBar(
    searchFieldValue: String = "",
    lg: List<GeocodingResponse> = listOf(),
    updateSearchFieldValue: (s: String) -> Unit,
    searchBoxTrigger: () -> Unit,
    geocodingSelectTrigger: (it: GeocodingResponse) -> Unit
){
    //bottom sheet implementation for selecting geocoding result
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            GeocodingResultList(
                lg
            ) {
                geocodingSelectTrigger(it)
                showBottomSheet = false
            }
        }
    }
    //

    Row {
        TextField(
            value = searchFieldValue,
            onValueChange = updateSearchFieldValue,
            label = { Text("Search") },
            singleLine = true
        )
        Button(onClick = {
            searchBoxTrigger()
            showBottomSheet = true
        }) {
            Text(text = "Search")
        }
    }
}
