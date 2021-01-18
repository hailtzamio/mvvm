package com.example.niceday.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val loading : MutableLiveData<Boolean> = MutableLiveData(false)

}