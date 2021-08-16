package com.antortest.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.antortest.ui.FirstFragment
import com.antortest.ui.SecondFragment


class ViewPagerAdapter(fa: Fragment): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
             0 -> FirstFragment()
             else -> SecondFragment()
         }
    }

}
