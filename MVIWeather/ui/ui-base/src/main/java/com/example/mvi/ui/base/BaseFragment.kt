package com.example.mvi.ui.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mvi.android.core.binding.FragmentViewBindingDelegate
import com.example.mvi.android.core.binding.viewBinding

abstract class BaseFragment<V : ViewBinding>(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initView()

    abstract fun getViewBinding(): V

}

fun <T: ViewBinding> BaseFragment<T>.viewBinding(viewBindingFactory: (View) -> T) =
    viewBinding(viewBindingFactory)
