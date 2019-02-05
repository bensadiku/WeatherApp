package com.bensadiku.weatherapp.data.provider

import com.bensadiku.weatherapp.data.db.entity.WeatherLocation

interface LocationProvider {

    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation):Boolean

    suspend  fun getPreferredLocationString():String
}