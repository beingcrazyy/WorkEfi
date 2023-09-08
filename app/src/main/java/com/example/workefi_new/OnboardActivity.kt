package com.example.workefi_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnboardActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: OnboardViewPageAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        //val wormDotsIndicator = findViewById<SpringDotsIndicator>(R.id.worm_dots_indicator)
        val continueButton = findViewById<ImageButton>(R.id.imageButton)

        viewPager = findViewById(R.id.slidingViewPager)
        viewPagerAdapter =  OnboardViewPageAdaptor(this)
        viewPager.adapter = viewPagerAdapter
        //wormDotsIndicator.attachTo(viewPager)

        intent = Intent(this,MainActivity::class.java)


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    continueButton.setOnClickListener(){
                        startActivity(intent)
                    }
                }
                else if (position == 0){
                    continueButton.setOnClickListener(){
                        changeViewPagerItem()
                    }
                }
                else{
                    continueButton.setOnClickListener(){
                        changeViewPagerItem()
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


    }

    private fun changeViewPagerItem() {
        val currentItem = viewPager.currentItem
        val totalItems = viewPager.adapter?.count ?: 0
        val nextItem = (currentItem+1) % totalItems
        viewPager.setCurrentItem(nextItem, true)
    }
}