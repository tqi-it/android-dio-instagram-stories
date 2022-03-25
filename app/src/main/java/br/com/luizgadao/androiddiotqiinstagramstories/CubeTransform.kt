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

    private var alpha = 0f
    private var scale = 1.0f
    private val factor = 0.28f
    var paint = Paint()
    var colorFilter: PorterDuffColorFilter? = null

    override fun transformPage(view: View, position: Float) {
        val deltaY = 0.6F

        view.pivotX = if (position < 0F) view.width.toFloat() else 0F
        view.pivotY = view.height * deltaY
        view.rotationY = 35F * position

        if (position > 0) {
            alpha = abs(1f - position)

            val value = abs(position) * 100
            colorFilter = applyLightness((-value).toInt())

            scale = 1.0f
            scale = (scale + (position * factor))
        } else {
            alpha = 1f - abs(position)

            var value = (abs(position) * 100).toInt()
            value = 100 + (100 - value) * -1
            colorFilter = applyLightness(-value)

            scale = 1.0f
            scale = 1 + abs(position * factor)
        }

        view.alpha = alpha

        view.scaleX = scale
        view.scaleY = scale

        paint.colorFilter = colorFilter
        view.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
    }

    private fun applyLightness(progress: Int): PorterDuffColorFilter {
        return if (progress > 0) {
            val value = progress * 255 / 100
            PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER)
        } else {
            val value = progress * -1 * 255 / 100
            PorterDuffColorFilter(Color.argb(value, 0, 0, 0), PorterDuff.Mode.SRC_ATOP)
        }
    }

}