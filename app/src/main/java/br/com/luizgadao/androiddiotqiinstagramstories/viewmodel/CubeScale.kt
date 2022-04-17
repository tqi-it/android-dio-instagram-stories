package br.com.luizgadao.androiddiotqiinstagramstories.viewmodel

import kotlin.math.abs

class CubeScale {

    private val VALUE_FLOAT_1F = 1f
    private val VALUE_FACTOR = 0.28f


    fun getAlpha(position: Float): Float {
        return if(position > 0) abs(VALUE_FLOAT_1F - position) else VALUE_FLOAT_1F - abs(position)
    }

    fun getScale(position: Float): Float {
        return (VALUE_FLOAT_1F + (position * VALUE_FACTOR))
    }
}