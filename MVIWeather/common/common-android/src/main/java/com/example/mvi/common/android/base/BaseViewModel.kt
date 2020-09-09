package com.example.mvi.common.android.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.example.mvi.common.android.event.Event
import com.example.mvi.common.android.event.EventObserver
import com.example.mvi.common.android.navigation.NavigationCommand

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {


    val navigationCommands: LiveData<Event<NavigationCommand>>
        get() = _navigationCommands

    private val _navigationCommands = MutableLiveData<Event<NavigationCommand>>()

//    private val navigationCommand: SingleLive
//
//    fun navigate(directions: NavDirections) {
//        navigationComm
//    }
}