package com.example.mvi.android.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class ViewBindingAdapter<T : ViewBindingAdapterItem, VB : ViewBinding>(
    diffCB: ViewBindingDiffUtils<T>
) : ListAdapter<T, ViewBindingHolder<T, VB>>(diffCB) {

    protected val ViewGroup.layoutInflater: LayoutInflater
        get() = LayoutInflater.from(this.context)

    override fun onBindViewHolder(holder: ViewBindingHolder<T, VB>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: ViewBindingHolder<T, VB>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.bind(getItem(position), payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemViewType
    }


}