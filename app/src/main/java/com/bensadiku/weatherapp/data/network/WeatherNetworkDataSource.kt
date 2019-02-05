package com.bensadiku.weatherapp.data.network

import androidx.lifecycle.LiveData
import com.bensadiku.weatherapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather : LiveData<CurrentWeatherResponse>

    suspend  fun fetchCurrentWeather(
        location:String,
        languageCode:String
    )
}