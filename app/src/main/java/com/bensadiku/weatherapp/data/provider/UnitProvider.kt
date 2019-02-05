package com.bensadiku.weatherapp.data.provider

import com.bensadiku.weatherapp.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem():UnitSystem
}