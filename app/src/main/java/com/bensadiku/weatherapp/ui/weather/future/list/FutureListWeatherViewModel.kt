package com.bensadiku.weatherapp.ui.weather.future.list

import androidx.lifecycle.ViewModel;
import com.bensadiku.weatherapp.data.provider.UnitProvider
import com.bensadiku.weatherapp.data.repository.ForecastRepository
import com.bensadiku.weatherapp.internal.UnitSystem
import com.bensadiku.weatherapp.internal.lazyDeferred
import com.bensadiku.weatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
