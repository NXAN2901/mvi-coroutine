package com.example.mvi.ui.splash

import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>(R.layout.fragment_splash) {

//    private val splashVM = SplashVM(application = requireActivity().application)
    private val binding by viewBinding(FragmentSplashBinding::inflate)

    override fun getViewBinding(): FragmentSplashBinding = binding


    override fun setUpView() {
        Handler().postDelayed({
            findNavController().navigate(R.id.openIntro)
        }, 1000)
    }

    override fun getViewModel(): SplashVM {
        TODO("Not yet implemented")
    }
}