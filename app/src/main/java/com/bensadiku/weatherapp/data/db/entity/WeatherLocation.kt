package com.bensadiku.weatherapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "weather_location")
data class WeatherLocation(
    val country: String,
    val lat: Double,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    @SerializedName("tz_id")
    val tzId: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}