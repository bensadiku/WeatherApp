package com.bensadiku.weatherapp.data.provider

import com.bensadiku.weatherapp.data.db.entity.WeatherLocation

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getPreferredLocationString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}