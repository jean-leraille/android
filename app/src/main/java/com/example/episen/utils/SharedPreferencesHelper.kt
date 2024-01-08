package com.example.episen.utils

import android.content.SharedPreferences
import com.example.episen.data.models.Commune
import com.google.gson.Gson

class SharedPreferencesHelper(private val sharedPreferences: SharedPreferences) {

    fun saveCurrentSiteDetails(data: Commune){
        val json = Gson().toJson(data)
        sharedPreferences.edit().putString(Constants.SELECTED_CITY_KEY, json).apply()
    }

    fun getCurrentSiteDetails(): Commune?{
        val json =  sharedPreferences.getString(Constants.SELECTED_CITY_KEY, "")
        if(json.isNullOrEmpty())
            return null
        return  Gson().fromJson(json, Commune::class.java)
    }
}