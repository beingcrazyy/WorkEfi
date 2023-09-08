package com.example.workefi_new.fragments

import com.shawnlin.numberpicker.NumberPicker

class CustomFormatter(
    private val context: WaterFragment,
    private val constantString: String
) : NumberPicker.Formatter {

    override fun format(value: Int): String {
        return "$value$constantString"
    }
}

