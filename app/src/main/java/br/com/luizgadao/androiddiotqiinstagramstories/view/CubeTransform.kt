package br.com.luizgadao.androiddiotqiinstagramstories.view

import android.graphics.Paint
import android.graphics.PorterDuffColorFilter
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import br.com.luizgadao.androiddiotqiinstagramstories.viewmodel.ApplyLightness
import br.com.luizgadao.androiddiotqiinstagramstories.viewmodel.CubeMoviment
import br.com.luizgadao.androiddiotqiinstagramstories.viewmodel.CubeScale

// ref: https://gist.github.com/delacrixmorgan/6b05ab74d1acb01b471fcc3151d70703
class CubeTransformer : ViewPager2.PageTransformer {

    private val cubeMoviment: CubeMoviment = CubeMoviment()
    private val cubeScale: CubeScale = CubeScale()
    private val cubeApplyLightness: ApplyLightness = ApplyLightness()
    private var paint = Paint()
    private var colorFilter: PorterDuffColorFilter? = null

    override fun transformPage(view: View, position: Float) {

        view.apply {
            pivotX = cubeMoviment.getPivotX(view = view, position = position)
            pivotY = cubeMoviment.getPivotY(height = height)
            rotationY = cubeMoviment.getRotationY(position = position)
            alpha = cubeScale.getAlpha(position = position)
            colorFilter = cubeApplyLightness.applyLightness(position = position)
            scaleX = cubeScale.getScale(position = position)
            scaleY = cubeScale.getScale(position = position)
            setLayerType(View.LAYER_TYPE_HARDWARE, paint)
        }
    }
}

