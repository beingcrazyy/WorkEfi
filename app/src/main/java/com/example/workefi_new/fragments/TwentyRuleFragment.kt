package com.example.workefi_new.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workefi_new.R
import com.shawnlin.numberpicker.NumberPicker

class TwentyRuleFragment  : Fragment(){

    private lateinit var hrPicker: NumberPicker
    private lateinit var minPicker: NumberPicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_twentyrule, container, false)

        hrPicker = rootView.findViewById(R.id.hour_picker)
        minPicker = rootView.findViewById(R.id.minute_picker)
        val customTypeface = resources.getFont(R.font.inter_bold)

        hrPicker.minValue = 0
        hrPicker.maxValue = 12
        hrPicker.value = 0
        hrPicker.typeface = customTypeface
        hrPicker.setSelectedTypeface(customTypeface)

        hrPicker.formatter = TwentyCustomFormatter(this, "h")

        minPicker.minValue = 0
        minPicker.maxValue = 59
        minPicker.value = 25
        minPicker.typeface = customTypeface
        minPicker.setSelectedTypeface(customTypeface)

        minPicker.formatter = TwentyCustomFormatter(this, "m")

        return rootView

    }
}
