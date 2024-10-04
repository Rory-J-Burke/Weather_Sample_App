package com.example.weathersampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathersampleapp.model.WeatherRepository
import com.example.weathersampleapp.model.dto.ForecastDay
import com.example.weathersampleapp.model.dto.GeocodingResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherSampleAppViewModel: ViewModel() {
    //viewmodel boiler-plate
    private val repository = WeatherRepository.getInstance()

    private val _uiState: MutableStateFlow<WeatherSampleAppUIState> = MutableStateFlow(
        WeatherSampleAppUIState()
    )

    val uiState: StateFlow<WeatherSampleAppUIState> = _uiState.asStateFlow()
    //

    fun onLaunch(){
        viewModelScope.launch {
            async { repository.fetchLatitude() }.await().let { lat ->
                async { repository.fetchLongitude() }.await().let { lon ->
                    if(lat != 0.0 && lon != 0.0) multicall(lat, lon)
                }
            }
        }
    }


    fun updateSearchFieldValue(s: String){
        viewModelScope.launch {
            _uiState.update { _uiState.value.copy(
                searchFieldValue = s
            ) }
        }
    }

    fun searchBoxTrigger(){
        viewModelScope.launch {
            _uiState.value.searchFieldValue.let { s ->
                async {
                    repository.directGeocoding(
                        q = s
                    )
                }.await()?.let { list ->
                    launch {
                        _uiState.update { _uiState.value.copy(
                            lg = list,
                            searchFieldValue = ""
                        ) }
                    }
                }
            }
        }
    }

    fun rowSelectTrigger(d: ForecastDay) {
        viewModelScope.launch { _uiState.update { _uiState.value.copy(d = d) } }
    }

    fun geocodingSelectTrigger(g: GeocodingResponse){
        viewModelScope.launch {
            repository.storeCoordinates(g.lat, g.lon)
            multicall(g.lat, g.lon)
        }
    }

    private suspend fun multicall(lat: Double, lon: Double){
        viewModelScope.launch {
            launch {
                async {
                    repository.currentWeather(lat, lon)
                }.await()?.let { cw ->
                    launch {
                        _uiState.update {
                            _uiState.value.copy(
                                cw = cw
                            )
                        }
                    }
                }
            }
            launch {
                async {
                    repository.dailyForecast(lat, lon)
                }.await()?.list?.let { lf ->
                    launch {
                        _uiState.update {
                            _uiState.value.copy(
                                lf = lf
                            )
                        }
                    }
                }
            }
        }.join()
    }
}