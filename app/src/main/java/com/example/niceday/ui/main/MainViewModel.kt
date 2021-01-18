package com.example.niceday.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.niceday.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    val widgetLiveData by lazy {
        return@lazy fetchHomeWidgets()
    }

    val widgetLiveData2 = MutableLiveData<Boolean>()

    private fun fetchHomeWidgets(): LiveData<Boolean> {
        val widgetResult = MutableLiveData<Boolean>()
        widgetResult.postValue(true)

        viewModelScope.launch {
            // run api
        }

        return widgetResult
    }

    fun getData() {
        viewModelScope.launch {
            widgetLiveData2.postValue(true)
        }
    }
}