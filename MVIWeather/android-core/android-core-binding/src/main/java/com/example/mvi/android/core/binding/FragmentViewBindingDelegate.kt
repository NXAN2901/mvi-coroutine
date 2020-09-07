package com.example.mvi.android.core.binding

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<V : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> V
) : ReadOnlyProperty<Fragment, V> {

    private var binding: V? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                        override fun onDestroy(owner: LifecycleOwner) {
                            binding = null
                        }
                    })
                }
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): V {
        val currentBinding = binding
        if (currentBinding != null) {
            return currentBinding
        }
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }
        return viewBindingFactory(thisRef.requireView()).also {
            this@FragmentViewBindingDelegate.binding = it
        }

    }
}

fun <V : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> V) =
    FragmentViewBindingDelegate(this, viewBindingFactory)

inline  fun <V: ViewBinding> AppCompatActivity.viewBinding(crossinline bindingInflater: (LayoutInflater) -> V) =
    lazy(LazyThreadSafetyMode.NONE) { bindingInflater.invoke(layoutInflater) }