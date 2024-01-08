package com.example.episen.data.repositories


import com.example.episen.data.network.RetrofitClient
import com.example.episen.data.models.Commune
import retrofit2.Call

class Repository (private val retrofitClient: RetrofitClient) {

    fun getCommunes(name: String, fields: String): Call<List<Commune>> {
        return retrofitClient.api.getCommunes(retrofitClient.headerMap, name, fields)
    }
}
