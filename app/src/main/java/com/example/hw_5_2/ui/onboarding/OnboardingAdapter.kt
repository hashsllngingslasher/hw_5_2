package com.example.hw_5_2.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_5_2.ui.onboarding.content.OnboardFirstFragment
import com.example.hw_5_2.ui.onboarding.content.OnboardSecondFragment
import com.example.hw_5_2.ui.onboarding.content.OnboardThirdFragment

class OnboardingAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    private val content = listOf<Fragment>(
        OnboardFirstFragment(),
        OnboardSecondFragment(),
        OnboardThirdFragment()
    )

    override fun getItemCount(): Int {
        return content.size
    }

    override fun createFragment(position: Int): Fragment {
        return content[position]
    }

}