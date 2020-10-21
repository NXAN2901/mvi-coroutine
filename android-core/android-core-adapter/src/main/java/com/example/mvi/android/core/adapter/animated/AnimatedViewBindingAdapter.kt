package com.example.mvi.android.core.adapter.animated

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingAdapterItem
import com.example.mvi.android.core.adapter.ViewBindingDiffUtils
import com.example.mvi.android.core.adapter.ViewBindingHolder

abstract class AnimatedViewBindingAdapter<T : ViewBindingAdapterItem, VB : ViewBinding>(diffCB: ViewBindingDiffUtils<T>) :
    ViewBindingAdapter<T, VB>(diffCB) {

    private var recyclerView: AnimatedRecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView as? AnimatedRecyclerView
    }

    override fun onViewAttachedToWindow(holder: ViewBindingHolder<T, VB>) {
        super.onViewAttachedToWindow(holder)
        if (holder is AnimatedItemHolder) {
            recyclerView?.onAddViewHolder(holder)
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewBindingHolder<T, VB>) {
        super.onViewDetachedFromWindow(holder)
        if (holder is AnimatedItemHolder) {
            recyclerView?.onRemoveViewHolder(holder)
        }
    }
}