package com.virunee.ricetomeetyousoundboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FixedTabsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
       return when(position) {
           0 -> AllSoundsFragment()
           1 -> EvelynFragment()
           2 -> NigelFragment()
           else -> AllSoundsFragment()
       }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "ALL SOUNDS"
            1 -> "EVELYN"
            2 -> "NIGEL"
            else -> null
        }
    }

}