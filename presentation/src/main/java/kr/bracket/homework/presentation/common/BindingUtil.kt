package kr.bracket.homework.presentation.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import kr.bracket.homework.presentation.R
import kotlin.math.roundToInt

@BindingAdapter("topics")
fun setTopics(view : FlexboxLayout, topics : List<String>){
    topics.forEach {
        view.addTopic(it)
    }
}

@SuppressLint("InflateParams")
fun FlexboxLayout.addTopic(text : String){
    val topic = LayoutInflater.from(context).inflate(R.layout.view_topic, null) as Chip
    topic.text = text

    val layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT)
    layoutParams.marginEnd =  context.dpToPx(6)

    topic.setOnClickListener {
        val redirectUrl = "https://github.com/topics/${topic.text}"
        it.context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(redirectUrl))
        )
    }

    addView(topic, childCount, layoutParams)
}

fun FlexboxLayout.clearChips(){
    val chipViews = (0 until childCount).mapNotNull { index ->
        val view = getChildAt(index)
        if (view is Chip) view else null
    }
    chipViews.forEach { removeView(it) }
}

fun Context.dpToPx(dp: Int): Int
        = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).roundToInt()