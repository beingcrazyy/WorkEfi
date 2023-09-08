package com.example.workefi_new.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workefi_new.R
import com.shawnlin.numberpicker.NumberPicker

class PomodoroFragment  : Fragment(){

    private lateinit var ttHrPicker: NumberPicker
    private lateinit var ttMinPicker: NumberPicker
    private lateinit var rtHrPicker: NumberPicker
    private lateinit var rtMinPicker: NumberPicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pomodoro, container, false)
        val customTypeface = resources.getFont(R.font.inter_bold)

        ttHrPicker = rootView.findViewById(R.id.tt_hour_picker)
        ttMinPicker = rootView.findViewById(R.id.tt_minute_picker)

        ttHrPicker.minValue = 0
        ttHrPicker.maxValue = 12
        ttHrPicker.value = 4
        ttHrPicker.typeface = customTypeface
        ttHrPicker.setSelectedTypeface(customTypeface)

        ttHrPicker.formatter = PomodoroCustomFormatter(this,"h")

        ttMinPicker.minValue = 0
        ttMinPicker.maxValue = 59
        ttMinPicker.value = 30
        ttMinPicker.typeface = customTypeface
        ttMinPicker.setSelectedTypeface(customTypeface)

        ttMinPicker.formatter = PomodoroCustomFormatter(this,"m")

        rtHrPicker = rootView.findViewById(R.id.rt_hour_picker)
        rtMinPicker = rootView.findViewById(R.id.rt_minute_picker)

        rtHrPicker.minValue = 0
        rtHrPicker.maxValue = 12
        rtHrPicker.value = 0
        rtHrPicker.typeface = customTypeface
        rtHrPicker.setSelectedTypeface(customTypeface)

        rtHrPicker.formatter = PomodoroCustomFormatter(this, "h")

        rtMinPicker.minValue = 0
        rtMinPicker.maxValue = 59
        rtMinPicker.value = 25
        rtMinPicker.typeface = customTypeface
        rtMinPicker.setSelectedTypeface(customTypeface)

        rtMinPicker.formatter = PomodoroCustomFormatter(this, "m")


        return rootView
    }
}
