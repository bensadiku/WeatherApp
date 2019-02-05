package com.bensadiku.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bensadiku.weatherapp.data.provider.UnitProvider
import com.bensadiku.weatherapp.data.repository.ForecastRepository

@Suppress("UNCHECKED_CAST")
class CurrentWeatherViewModelFactory (
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository,unitProvider)as T
    }
}