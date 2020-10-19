package com.example.mvi.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.example.mvi.ui.base.event.Event
import com.example.mvi.ui.base.navigation.NavigationCommand

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val navigationCommands: LiveData<Event<NavigationCommand>>
        get() = _navigationCommands

    private val _navigationCommands = MutableLiveData<Event<NavigationCommand>>()

    fun navigateTo(directions: NavDirections) {
        _navigationCommands.postValue(Event<NavigationCommand>(NavigationCommand.To(directions)))
    }
}