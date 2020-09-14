package com.example.mvi.ui.splash

import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding
import com.example.mvi.ui.splash.viewmodel.SplashVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>(R.layout.fragment_splash) {

    private val splashVM : SplashVM by viewModel()

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun getViewBinding(): FragmentSplashBinding = binding

    override fun setUpView() {
        Handler().postDelayed({
            findNavController().navigate(R.id.openIntro)
        }, 1000)
    }

    override fun getViewModel(): SplashVM = splashVM
}