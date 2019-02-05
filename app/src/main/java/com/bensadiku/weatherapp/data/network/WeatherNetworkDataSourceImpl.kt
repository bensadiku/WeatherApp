package com.bensadiku.weatherapp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bensadiku.weatherapp.data.network.response.CurrentWeatherResponse
import com.bensadiku.weatherapp.data.network.response.FutureWeatherResponse
import com.bensadiku.weatherapp.internal.NoConnectivityException

const val TAG = "CONNECTIVITY"
const val FORECAST_DAYS_COUNT=7

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService

) : WeatherNetworkDataSource {

    private  val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try{
            val fetchCurrentWeather = apixuWeatherApiService.getCurrentWeather(location,languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchCurrentWeather)
        }
        catch (e:NoConnectivityException){
            Log.e(TAG,"No internet connection",e)
        }
    }

    //to fetch future weather////

    private  val _downloadedFutureWeather = MutableLiveData<FutureWeatherResponse>()

    override val downloadedFutureWeather :LiveData<FutureWeatherResponse>
    get() = _downloadedFutureWeather

    override suspend fun fetchFutureWeather(location: String, languageCode: String) {
        try{
            val fetchFutureWeather = apixuWeatherApiService.
                getFutureWeather(location,FORECAST_DAYS_COUNT,languageCode)
                .await()
            _downloadedFutureWeather.postValue(fetchFutureWeather)
        }catch (e:NoConnectivityException){
            Log.e(TAG,"No internet Connection",e)
        }
    }
}