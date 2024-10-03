package com.example.weathersampleapp.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.json.JSONObject

@Serializable
data class GeocodingResponse(
    @SerialName("name")
    val name: String,

    @Transient
    @SerialName("local_names")
    val localNames: JSONObject? = null,

    @SerialName("lat")
    val lat: Double,

    @SerialName("lon")
    val lon: Double,

    @SerialName("country")
    val country: String,

    @SerialName("state")
    val state: String? = null,
)

@Serializable
data class ZipGeocodingResponse(
    @SerialName("zip")
    val zip: String,

    @SerialName("name")
    val name: String,

    @SerialName("lat")
    val lat: Double,

    @SerialName("lon")
    val lon: Double,

    @SerialName("country")
    val country: String,
)