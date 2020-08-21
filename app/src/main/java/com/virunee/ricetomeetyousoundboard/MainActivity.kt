package com.virunee.ricetomeetyousoundboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        var viewPager: ViewPager = findViewById(R.id.viewpager)
        var pagerAdapter = FixedTabsPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        //Give the TabLayout the ViewPager
        var tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)

    }
}