package com.example.mvi.android.core.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class ViewBindingDiffUtils<T: ViewBindingAdapterItem>: DiffUtil.ItemCallback<T>()