package com.example.mvi.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.mvi.ui.base.event.Event

inline fun <T> LiveData<Event<T>>.observerEvent(owner: LifecycleOwner, crossinline onEventUnHandledContent: (T) -> Unit) {
    observe(owner, Observer { event -> event?.getContentIfNotHandled()?.let(onEventUnHandledContent) })
}