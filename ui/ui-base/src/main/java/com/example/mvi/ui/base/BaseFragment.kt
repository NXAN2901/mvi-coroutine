package com.example.mvi.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.mvi.ui.base.navigation.NavigationCommand

abstract class BaseFragment<T : ViewBinding, V : BaseViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().navigationCommands.observerEvent(viewLifecycleOwner) { command ->
            when (command) {
                is NavigationCommand.To -> findNavController().navigate(command.directions)
            }
        }
        setUpView()
    }

    abstract fun getViewBinding(): T

    abstract fun getViewModel(): V

    abstract fun setUpView()

}