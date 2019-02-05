package com.bensadiku.weatherapp

import android.app.Application
import com.bensadiku.weatherapp.data.db.ForecastDatabase
import com.bensadiku.weatherapp.data.network.*
import com.bensadiku.weatherapp.data.repository.ForecastRepository
import com.bensadiku.weatherapp.data.repository.ForecastRepositoryImpl
import com.bensadiku.weatherapp.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind()from singleton { ForecastDatabase(instance()) }
        bind()from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }

        bind()from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }

        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance()) }

        bind() from provider { CurrentWeatherViewModelFactory (instance()) }
    }


    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

}