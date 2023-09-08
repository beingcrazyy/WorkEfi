package com.example.workefi_new

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class OnboardViewPageAdaptor(private val context : Context) : PagerAdapter() {

    private var layoutInflater : LayoutInflater? = null

    private val imgArray = arrayOf(
        R.drawable.water_splash,
        R.drawable.pomodoro_alarm,
        R.drawable.twenty_rule_timer
    )

    private val texts = arrayOf(
        "Water is the essence of life, the elixir that sustains us all. It is a fundamental resource that keeps our bodies functioning at their best. Yet, in the fast-paced world we live in, it's easy to overlook the simple act of drinking water regularly. Dehydration can sneak up on us, leading to a range of health issues, decreased productivity, and a general sense of fatigue.\n" +
                "\n" +
                "WorkEfi is here to be your faithful companion, reminding you to stay hydrated and maintain a healthy water intake throughout the day. With our intuitive interface and customizable features, we aim to make drinking water a delightful and effortless habit",
        "In a fast-paced world filled with distractions, staying focused and productive can be a real challenge. But fear not, for the Pomodoro Technique is here to revolutionize the way you work, study, and accomplish your goals. \n" +
                "\n" +
                "The technique is elegantly simple yet incredibly effective. It revolves around the concept of breaking work into intervals, typically 25 minutes in duration, known as \"Pomodoros.\" Each Pomodoro is followed by a short 5-minute break, allowing your mind to rest and recharge. After completing four consecutive Pomodoros, you earn a longer break, typically lasting 15-30 minutes.",
        "With modern life tethered to screens, our eyes suffer from prolonged exposure to digital devices. The 20-20-20 Rule is a simple, science-backed technique to alleviate digital eye strain and promote eye health. Every 20 minutes, take a 20-second break and focus on an object 20 feet away. \n" +
                "\n" +
                "By adhering to this rule, you give your eyes the much-needed respite, reducing fatigue, dryness, and discomfort caused by staring at screens. WorkEfi ensures you never miss a prompt, with customizable intervals and user-friendly features. Embrace better eye care and boost your productivity. Let the 20-20-20 Rule"
    )

    private val heading = arrayOf(
        "Drinking\n" +
                "Water",
        "Pomodoro\n" +
                "Technique",
        "20-20-20\n" +
                "Rule"
    )

    override fun getCount(): Int {
        return heading.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider_layout, container, false)

        val img = view.findViewById<ImageView>(R.id.ref_Image)
        val txtHeading = view.findViewById<TextView>(R.id.title)
        val txtDecription = view.findViewById<TextView>(R.id.decription)

        img.setImageResource(imgArray[position])
        txtHeading.text = heading[position].toString()
        txtDecription.text = texts[position].toString()

        container.addView(view)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}