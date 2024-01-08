package com.example.episen.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.episen.BaseViewModel

class HomeViewModel :  BaseViewModel<HomeViewModel.States>() {


    sealed class States {
        object NoConnection : States()
        data class OnConnection(var response: String?) : States()
    }
}