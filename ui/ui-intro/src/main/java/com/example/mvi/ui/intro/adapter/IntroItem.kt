package com.example.mvi.ui.intro.adapter

import com.example.mvi.android.core.adapter.ViewBindingAdapterItem

class IntroItem(val header: String, val description: String) : ViewBindingAdapterItem {

    override val itemViewType: Int
        get() = INTRO_NORMAL_VIEW_TYPE

    companion object {
        const val INTRO_NORMAL_VIEW_TYPE = 0
    }
}