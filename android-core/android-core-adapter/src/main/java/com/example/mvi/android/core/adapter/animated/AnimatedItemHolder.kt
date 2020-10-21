package com.example.mvi.android.core.adapter.animated

import androidx.viewbinding.ViewBinding
import com.example.mvi.android.core.adapter.ViewBindingAdapterItem
import com.example.mvi.android.core.adapter.ViewBindingHolder

abstract class AnimatedItemHolder<T: ViewBindingAdapterItem, out VB: ViewBinding>(vb: VB) : ViewBindingHolder<T, VB>(vb) {

    abstract fun onEnterFromTop()
    abstract fun onExitToTop()
    abstract fun onEnterFromBottom()
    abstract fun onExitToBottom()

}