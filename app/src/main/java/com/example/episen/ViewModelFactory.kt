package com.example.episen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.episen.data.repositories.Repository
import com.example.episen.ui.home.HomeViewModel
import com.example.episen.utils.SharedPreferencesHelper

class ViewModelFactory(private val repository: Repository,
                       private val sharedPreferenceHelper: SharedPreferencesHelper
)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java)
                                        -> return HomeViewModel(repository, sharedPreferenceHelper) as T
            else -> throw IllegalArgumentException(String.format("%s Not Found", modelClass.simpleName))
        }
    }
}