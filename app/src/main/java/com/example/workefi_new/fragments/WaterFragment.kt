package com.example.workefi_new.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.workefi_new.R
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.shawnlin.numberpicker.NumberPicker
import java.util.*

class WaterFragment : Fragment() {
    private lateinit var hrPicker: NumberPicker
    private lateinit var minPicker: NumberPicker
    private lateinit var startTimePicker: MaterialTimePicker
    private lateinit var endTimePicker: MaterialTimePicker
    private lateinit var calender: Calendar

    private lateinit var startTime : TextView
    private lateinit var endTime : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_water, container, false)

        hrPicker = rootView.findViewById(R.id.hour_picker)
        minPicker = rootView.findViewById(R.id.minute_picker)
        val customTypeface = resources.getFont(R.font.inter_bold)

        hrPicker.minValue = 0
        hrPicker.maxValue = 12
        hrPicker.value = 0
        hrPicker.typeface = customTypeface
        hrPicker.setSelectedTypeface(customTypeface)

        hrPicker.formatter = CustomFormatter(this, "h")

        minPicker.minValue = 0
        minPicker.maxValue = 59
        minPicker.value = 25
        minPicker.typeface = customTypeface
        minPicker.setSelectedTypeface(customTypeface)

        minPicker.formatter = CustomFormatter(this, "m")

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hrPicker = view.findViewById(R.id.hour_picker)
        minPicker = view.findViewById(R.id.minute_picker)

        view.findViewById<View>(R.id.startCard).setOnClickListener {
            showStartTimePicker()
        }

        view.findViewById<View>(R.id.endCard).setOnClickListener {
            showEndTimePicker()
        }
    }

    private fun showStartTimePicker() {
        startTime = requireView().findViewById(R.id.startTime)
        startTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(startTimePicker.hour)
            .setMinute(startTimePicker.minute)
            .setTitleText("Select Start Time")
            .build()
        startTimePicker.show(requireActivity().supportFragmentManager, "Start Time")

        updateStartTime()
        startTimePicker.addOnPositiveButtonClickListener {

            if (startTimePicker.hour > 12) {
               startTime.text =
                    buildString {
                        append(String.format("%02d", startTimePicker.hour - 12))
                        append(":")
                        append(String.format("%02d", startTimePicker.minute))
                        append(" PM")
                    }
            } else {
               startTime.text=
                    buildString {
                        append(String.format("%02d", startTimePicker.hour))
                        append(":")
                        append(String.format("%02d", startTimePicker.minute))
                        append(" AM")
                    }
            }


//            calender = Calendar.getInstance()
//            calender[Calendar.HOUR_OF_DAY] = startTimePicker.hour
//            calender[Calendar.MINUTE] = startTimePicker.minute
//            calender[Calendar.SECOND] = 0
//            calender[Calendar.MILLISECOND] = 0

            // Update your UI element with the formattedTime, e.g., binding.startTime.text = formattedTime
        }
    }

    private fun showEndTimePicker() {
        endTime = requireView().findViewById(R.id.endTime)
        endTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(2)
            .setMinute(30)
            .setTitleText("Select End Time")
            .build()
        endTimePicker.show(requireActivity().supportFragmentManager, "End Time")
        updateEndTime()
        endTimePicker.addOnPositiveButtonClickListener {
            if (endTimePicker.hour > 12) {
               endTime.text =
                    buildString {
                        append(String.format("%02d", endTimePicker.hour - 12))
                        append(":")
                        append(String.format("%02d", endTimePicker.minute))
                        append(" PM")
                    }
            } else {
               endTime.text=
                    buildString {
                        append(String.format("%02d", endTimePicker.hour))
                        append(":")
                        append(String.format("%02d", endTimePicker.minute))
                        append(" AM")
                    }
            }



//            calender = Calendar.getInstance()
//            calender[Calendar.HOUR_OF_DAY] = endTimePicker.hour
//            calender[Calendar.MINUTE] = endTimePicker.minute
//            calender[Calendar.SECOND] = 0
//            calender[Calendar.MILLISECOND] = 0

        }
    }

    private fun updateStartTime(){
        startTime = requireView().findViewById(R.id.startTime)

        val dashboardFragment = parentFragmentManager.findFragmentByTag("f0") as? DashboardFragment
        dashboardFragment?.updateDWstartTime("From : " + startTime.text as String)
    }

    private fun updateEndTime(){
        endTime = requireView().findViewById(R.id.endTime)

        val dashboardFragment = parentFragmentManager.findFragmentByTag("f0") as? DashboardFragment
        dashboardFragment?.updateDWendTime("To : " + endTime.text as String)
    }

}

