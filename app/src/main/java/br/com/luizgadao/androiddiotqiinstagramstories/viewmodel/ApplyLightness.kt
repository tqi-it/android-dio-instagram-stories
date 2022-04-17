package br.com.luizgadao.androiddiotqiinstagramstories.viewmodel

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter

import kotlin.math.abs

class ApplyLightness {

    private val MAX_VALUE_: Int = 100
    private val MAX_VALUE_RGB_: Int = 255

    fun applyLightness(position: Float): PorterDuffColorFilter {
        val value = (((abs(position) * MAX_VALUE_) * MAX_VALUE_RGB_) / MAX_VALUE_).toInt()
        return if(position > 0.0f){
            PorterDuffColorFilter(Color.argb(-value, 255, 255, 255), PorterDuff.Mode.SRC_OVER)
        } else {
            PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP)
        }
    }
}