package com.bensadiku.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.bensadiku.weatherapp.data.provider.UnitProvider
import com.bensadiku.weatherapp.data.repository.ForecastRepository
import com.bensadiku.weatherapp.internal.UnitSystem
import com.bensadiku.weatherapp.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred() {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeferred(){
        forecastRepository.getWeatherLocation()
    }
}
