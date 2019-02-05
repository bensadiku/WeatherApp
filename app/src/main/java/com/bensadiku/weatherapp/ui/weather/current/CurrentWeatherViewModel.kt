package com.bensadiku.weatherapp.ui.weather.current

import com.bensadiku.weatherapp.data.provider.UnitProvider
import com.bensadiku.weatherapp.data.repository.ForecastRepository
import com.bensadiku.weatherapp.internal.lazyDeferred
import com.bensadiku.weatherapp.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository,unitProvider) {


    val weather by lazyDeferred() {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }


}
