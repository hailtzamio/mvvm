package com.example.niceday.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<VM : ViewModel, T : ViewDataBinding> : AppCompatActivity() {

    companion object {
        const val ID_NULL = -1
    }

    lateinit var viewModel: VM
    lateinit var binding: T

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getInstanceViewModel(): VM
    abstract fun observeViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getInstanceViewModel()
        try {
            binding = DataBindingUtil.setContentView(this, getLayoutId())
            if (getBindingViewModelId() != ID_NULL) {
                binding.setVariable(getBindingViewModelId(), viewModel)
            }
            binding.lifecycleOwner = this
            binding.executePendingBindings()
        } catch (e: Exception) {
            if (getLayoutId() != ID_NULL) {
                setContentView(getLayoutId())
            }
        }
        initViews()
        observeViewModels()
    }

    @IdRes
    open fun getContainerId(): Int {
        return ID_NULL
    }

    @IdRes
    open fun getBindingViewModelId(): Int {
        return ID_NULL
    }

    protected open fun initViews() {}
}