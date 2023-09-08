package com.example.workefi_new.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.workefi_new.MainActivity
import com.example.workefi_new.R
class DashboardFragment  : Fragment(){

    private lateinit var DWstartTime : TextView
    private lateinit var DWendTime : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val goToWaterFragment = view.findViewById<CardView>(R.id.Drinking_water_card)
        goToWaterFragment.setOnClickListener {
            (requireActivity() as MainActivity).navigateToWaterFragment()
        }

        val goToPomodoroFragment = view.findViewById<CardView>(R.id.pomodoro_card)
        goToPomodoroFragment.setOnClickListener {
            (requireActivity() as MainActivity).navigateToPomodoroFragment()
        }

        val goToTwentyFragment = view.findViewById<CardView>(R.id.twenty_rule_card)
        goToTwentyFragment.setOnClickListener {
            (requireActivity() as MainActivity).navigateToTwentyFragment()
        }

        return view
    }

    fun updateDWstartTime(newText: String) {
        DWstartTime = requireView().findViewById(R.id.DWstartTime)
        DWstartTime.text = newText
    }

    fun updateDWendTime(newText: String) {
        DWendTime = requireView().findViewById(R.id.DWendTime)
        DWendTime.text = newText
    }
}
