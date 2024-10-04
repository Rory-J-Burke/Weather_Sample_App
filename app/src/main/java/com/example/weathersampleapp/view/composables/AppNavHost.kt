package com.example.weathersampleapp.view.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weathersampleapp.view.NavigationItem
//import com.example.weathersampleapp.viewmodel.WeatherSampleAppViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.Current.route,
    navController: NavHostController,
//    vm: WeatherSampleAppViewModel = viewModel()
) {
//    val uiState by vm.uiState.collectAsStateWithLifecycle()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Current.route) {
//            WeatherPanel(
//                navController: NavHostController,
//                searchFieldValue: String = "",
//                cw: CurrentWeatherResponse = DUMMY_CURRENT_WEATHER,
//                l: List<ForecastDay> = listOf(),
//                updateSearchFieldValue: (s: String) -> Unit,
//                searchBoxTrigger: () -> Unit,
//                rowSelectTrigger: (d: ForecastDay) -> Unit
//            )
        }

        composable(NavigationItem.ForecastDayDetail.route) {
//            DailyForecastDetailPanel(
//                d: ForecastDay = DUMMY_FORECAST_DAY
//            )
        }
    }
}
