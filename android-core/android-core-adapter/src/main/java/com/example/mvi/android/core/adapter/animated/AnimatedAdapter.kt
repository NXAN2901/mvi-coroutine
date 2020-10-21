package com.example.mvi.android.core.adapter.animated

import androidx.recyclerview.widget.RecyclerView

abstract class AnimatedAdapter<V : AnimatedItemHolder<*, *>> : RecyclerView.Adapter<V>() {

    private var recyclerView: AnimatedRecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView as? AnimatedRecyclerView
    }

    override fun onViewAttachedToWindow(holder: V) {
        super.onViewAttachedToWindow(holder)
        recyclerView?.onAddViewHolder(holder)
    }

    override fun onViewDetachedFromWindow(holder: V) {
        super.onViewDetachedFromWindow(holder)
        recyclerView?.onRemoveViewHolder(holder)
    }
}