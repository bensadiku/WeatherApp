package com.bensadiku.weatherapp.data.repository

import androidx.lifecycle.LiveData
import com.bensadiku.weatherapp.data.db.entity.WeatherLocation
import com.bensadiku.weatherapp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {

   suspend  fun getCurrentWeather(metric:Boolean):LiveData<out UnitSpecificCurrentWeatherEntry>
   suspend  fun getWeatherLocation():LiveData<WeatherLocation>
}