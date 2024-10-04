package com.example.weathersampleapp.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathersampleapp.view.ui.theme.WeatherSampleAppTheme

@Composable
fun WeatherSearchBar(
    searchFieldValue: String = "",
    updateSearchFieldValue: (s: String) -> Unit,
    searchBoxTrigger: () -> Unit,
){
    Row {
        TextField(
            value = searchFieldValue,
            onValueChange = updateSearchFieldValue,
            label = { Text("Search") },
            singleLine = true
        )
        Button(onClick = {
            searchBoxTrigger()
        }) {
            Text(text = "Search")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherSearchBarPreview() {
    WeatherSampleAppTheme {
        WeatherSearchBar(
            "Android",
            {},
            {}
        )
    }
}