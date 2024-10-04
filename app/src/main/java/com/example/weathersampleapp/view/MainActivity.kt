package com.example.weathersampleapp.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.weathersampleapp.view.composables.AppNavHost
import com.example.weathersampleapp.view.ui.theme.WeatherSampleAppTheme
import com.example.weathersampleapp.viewmodel.WeatherSampleAppViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var vm: WeatherSampleAppViewModel

    override fun onStart() {
        super.onStart()

        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location : Location? ->
                        //Shared Preferences Implementation (Not Being thread safe)
                        //leads to race conditions.
                        //If I had more time, I would dedicate a Room Database to this,
                        //with a full history of users searches.
                        getSharedPreferences(
                            "CoordCache", MODE_PRIVATE
                        ).edit().apply{
                            putFloat(
                                "LAT_KEY",
                                (location?.latitude ?: 0.0).toFloat()
                            )
                            putFloat(
                                "LON_KEY",
                                (location?.longitude ?: 0.0).toFloat()
                            )
                            apply()
                        }
                    }
                vm.onLaunch()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            WeatherSampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    vm = viewModel()

                    fusedLocationClient = LocationServices
                    .getFusedLocationProviderClient(this)

                    if (ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        requestPermissions(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            ),
                            1
                            )
                    }

                    fusedLocationClient.lastLocation
                        .addOnSuccessListener { location : Location? ->
                            getSharedPreferences(
                                "CoordCache", MODE_PRIVATE
                            ).edit().apply{
                                putFloat(
                                    "LAT_KEY",
                                    (location?.latitude ?: 0.0).toFloat()
                                )
                                putFloat(
                                    "LON_KEY",
                                    (location?.longitude ?: 0.0).toFloat()
                                )
                                apply()
                            }
                        }
                    vm.onLaunch()

                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = rememberNavController(),
                        vm = vm
                    )
                }
            }
        }
    }
}
