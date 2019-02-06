package com.bensadiku.weatherapp.ui.weather.future.detail

import androidx.lifecycle.ViewModel;
import com.bensadiku.weatherapp.data.provider.UnitProvider
import com.bensadiku.weatherapp.data.repository.ForecastRepository
import com.bensadiku.weatherapp.internal.lazyDeferred
import com.bensadiku.weatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate


class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}