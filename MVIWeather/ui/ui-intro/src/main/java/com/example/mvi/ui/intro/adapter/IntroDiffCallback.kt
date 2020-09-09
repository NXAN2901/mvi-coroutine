package com.example.mvi.ui.intro.adapter

import com.example.mvi.android.core.adapter.ViewBindingDiffUtils

object IntroDiffCallback: ViewBindingDiffUtils<IntroItem>() {
    override fun areItemsTheSame(oldItem: IntroItem, newItem: IntroItem): Boolean {
        return oldItem.header == newItem.header
    }

    override fun areContentsTheSame(oldItem: IntroItem, newItem: IntroItem): Boolean {
        return oldItem.description == newItem.description
    }

}