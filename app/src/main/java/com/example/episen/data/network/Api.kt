package com.example.episen.data.network

import com.example.episen.data.models.Commune
import retrofit2.Call
import retrofit2.http.*


interface Api {
    @GET("communes")
    fun getCommunes(
        @HeaderMap headerMap: HashMap<String, String>,
        @Query("nom") name: String,
        @Query("fields") fields: String
    ): Call<List<Commune>>
}
