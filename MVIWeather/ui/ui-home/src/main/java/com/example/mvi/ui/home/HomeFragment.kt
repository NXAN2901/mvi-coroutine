package com.example.mvi.ui.home

import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.home.databinding.FragmentHomeBinding
import com.example.mvi.ui.home.viewmodel.HomeVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(R.layout.fragment_home) {

    private val homeVM: HomeVM by viewModel()
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun getViewBinding(): FragmentHomeBinding = binding

    override fun getViewModel(): HomeVM = homeVM

    override fun setUpView() {

    }

}