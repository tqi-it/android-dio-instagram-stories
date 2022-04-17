package br.com.luizgadao.androiddiotqiinstagramstories.viewmodel

import android.view.View

class CubeMoviment {

    private val MIN_VALUE = 0f
    private val VALUE_DELTAY = 0.6f
    private val VALUE_DEFAULT_ROTATION = 35f

    fun getPivotX(view: View, position: Float): Float {
        return if (position < MIN_VALUE) {
            view.width.toFloat()
        } else {
            MIN_VALUE
        }
    }

    fun getPivotY(height: Int): Float{
        return height * VALUE_DELTAY
    }

    fun getRotationY(position: Float): Float {
        return VALUE_DEFAULT_ROTATION * position
    }
}
