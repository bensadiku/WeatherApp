package com.bensadiku.weatherapp.data.network.response

import com.bensadiku.weatherapp.data.db.entity.FutureWeatherEntry
import com.google.gson.annotations.SerializedName

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)