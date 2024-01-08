package com.example.episen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S>() : ViewModel() {
    val stateLiveData: MutableLiveData<S> by lazy {
        MutableLiveData<S>()
    }
}