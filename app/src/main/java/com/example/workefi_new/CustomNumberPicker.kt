package com.example.workefi_new

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.EditText
import android.widget.NumberPicker

class CustomNumberPicker : NumberPicker {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    // Custom typeface property
    private var customTypeface: Typeface? = null
        set(value) {
            field = value
            applyCustomTypeface()
        }

    override fun addView(child: android.view.View?) {
        super.addView(child)
        updateView(child)
    }

    override fun addView(child: android.view.View?, params: android.view.ViewGroup.LayoutParams?) {
        super.addView(child, params)
        updateView(child)
    }

    override fun addView(child: android.view.View?, index: Int, params: android.view.ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        updateView(child)
    }

    private fun updateView(view: android.view.View?) {
        if (view is EditText) {
            applyCustomTypeface()
            val originalText = view.text.toString()
            val constantLetter = "X" // Replace with your constant letter
            val newText = "$originalText$constantLetter"
            view.setText(newText)
            view.textSize = view.textSize * 0.25f // Adjust the size as needed
        }
    }

    private fun applyCustomTypeface() {
        customTypeface?.let { typeface ->
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                if (child is EditText) {
                    child.typeface = typeface
                }
            }
        }
    }
}


