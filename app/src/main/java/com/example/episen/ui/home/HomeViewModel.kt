package com.example.episen.ui.home

import android.util.Log
import com.example.episen.BaseViewModel
import com.example.episen.data.models.Commune
import com.example.episen.data.repositories.Repository
import com.example.episen.utils.SharedPreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val repository: Repository,
    private val sharedPreferences: SharedPreferencesHelper
) :  BaseViewModel<HomeViewModel.States>() {


    fun getCommunes(name: String, fields: String){
        repository.getCommunes(name, fields)
            .enqueue(object : Callback<List<Commune>> {
                override fun onFailure(call: Call<List<Commune>>, t: Throwable) {
                    Log.d("dev0", "On Failure")
                }
                override fun onResponse(
                    call: Call<List<Commune>>,
                    response: Response<List<Commune>>
                ) {

                    Log.d("dev0", "On Response")
                    stateLiveData.value = States.OnGetCommunes(response.body())
                }
            })
    }

    sealed class States {
        object NoConnection : States()
        data class OnGetCommunes(var response: List<Commune>?) : States()
    }
}