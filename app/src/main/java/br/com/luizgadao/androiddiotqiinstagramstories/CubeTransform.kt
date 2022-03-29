package br.com.luizgadao.androiddiotqiinstagramstories

import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

// ref: https://gist.github.com/delacrixmorgan/6b05ab74d1acb01b471fcc3151d70703
class CubeTransformer : ViewPager2.PageTransformer {
    private val factor = 0.28f
    private var paint = Paint()

    override fun transformPage(view: View, position: Float) {
        val deltaY = 0.6F

        if (position > 0) {
            view.alpha = abs(1f - position)
            view.pivotX = 0F
        } else {
            view.alpha  = 1f - abs(position)
            view.pivotX = view.width.toFloat()
        }

        view.pivotY = view.height * deltaY
        view.rotationY = 35F * position

        val scale = 1 + abs(position * factor)
        view.scaleX = scale
        view.scaleY = scale

        val progress = (abs(position) * 100).toInt()
        paint.colorFilter = applyLightness(progress)
        view.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
    }

    private fun applyLightness(progress: Int): PorterDuffColorFilter {
        val value = abs(progress) * 255 / 100
        return if (progress > 0) {
            PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP)
        } else {
            PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER)
        }
    }
}