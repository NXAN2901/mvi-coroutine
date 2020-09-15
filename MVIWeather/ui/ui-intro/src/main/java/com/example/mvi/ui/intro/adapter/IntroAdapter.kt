package com.example.mvi.ui.intro.adapter

import android.view.ViewGroup
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingHolder
import com.example.mvi.ui.intro.databinding.ViewIntroPageBinding

class IntroAdapter : ViewBindingAdapter<IntroItem, ViewIntroPageBinding>(IntroDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingHolder<IntroItem, ViewIntroPageBinding> {
        val inflater = parent.layoutInflater
        return IntroVH(ViewIntroPageBinding.inflate(inflater, parent, false))
    }

}

class IntroVH(binding: ViewIntroPageBinding) :
    ViewBindingHolder<IntroItem, ViewIntroPageBinding>(binding) {
    override fun bind(item: IntroItem) {
        binding.tvIntroHeader.text = item.header
        binding.tvIntroDescription.text = item.description
    }

}