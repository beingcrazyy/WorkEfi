package com.example.workefi_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.workefi_new.fragments.DashboardFragment
import com.example.workefi_new.fragments.PomodoroFragment
import com.example.workefi_new.fragments.TwentyRuleFragment
import com.example.workefi_new.fragments.WaterFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs(){
        val adaptor = TabLayoutViewPagerAdaptor(supportFragmentManager)
        adaptor.addFragment(DashboardFragment(), "Dashboard\nLayout")
        adaptor.addFragment(WaterFragment(), "Drinking\nWater")
        adaptor.addFragment(PomodoroFragment(),"Pomodoro\nTechnique")
        adaptor.addFragment(TwentyRuleFragment(),"20-20-20\nRule")

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabs = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = adaptor
        tabs.setupWithViewPager(viewPager)
    }

    fun navigateToWaterFragment() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.currentItem = 1
    }
    fun navigateToPomodoroFragment() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.currentItem = 2
    }
    fun navigateToTwentyFragment() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.currentItem = 3
    }

}