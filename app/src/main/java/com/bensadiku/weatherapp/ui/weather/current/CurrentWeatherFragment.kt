package com.bensadiku.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.bensadiku.weatherapp.R
import com.bensadiku.weatherapp.data.network.ApixuWeatherApiService
import com.bensadiku.weatherapp.data.network.ConnectivityInterceptor
import com.bensadiku.weatherapp.data.network.ConnectivityInterceptorImpl
import com.bensadiku.weatherapp.data.network.WeatherNetworkDataSourceImpl
import com.bensadiku.weatherapp.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        bindUI()
//
//        val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
//        val weatherNetweorkDataSource = WeatherNetworkDataSourceImpl(apiService)
//        weatherNetweorkDataSource.downloadedCurrentWeather.observe(this, Observer {
//            textView.text=  it.toString()
//        })
//
//        GlobalScope.launch (Dispatchers.Main){
//            weatherNetweorkDataSource.fetchCurrentWeather("Pristine","en")
//        }


    }

    private fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()
    }
}
