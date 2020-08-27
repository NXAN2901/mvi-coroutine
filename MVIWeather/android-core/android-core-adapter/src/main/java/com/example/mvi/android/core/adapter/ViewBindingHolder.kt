package com.example.mvi.android.core.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewBindingHolder<T: ViewBindingAdapterItem, out VB: ViewBinding>(
    protected val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)

    open fun bind(item: T, payloads: List<Any>) {
        if (payloads.isEmpty()) {
            bind(item)
        }
    }

}