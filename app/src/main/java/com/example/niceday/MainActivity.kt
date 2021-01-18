package com.example.niceday

import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import com.example.niceday.base.BaseActivity
import com.example.niceday.ui.main.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ViewDataBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getData()
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }

    override fun getInstanceViewModel(): MainViewModel {
        return MainViewModel()
    }

    override fun observeViewModels() {
        viewModel.widgetLiveData

        viewModel.widgetLiveData2.observe(this) {
            Log.d("hailpt", "response here")
        }
    }
}