package com.example.workefi_new.fragments

import com.shawnlin.numberpicker.NumberPicker

class PomodoroCustomFormatter(
    private val context: PomodoroFragment,
    private val constantString: String
) : NumberPicker.Formatter {

    override fun format(value: Int): String {
        return "$value$constantString"
    }
}
