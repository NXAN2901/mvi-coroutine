package com.example.mvi.ui.intro.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CurveView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val path by lazy {
        Path()
    }

    private val paint by lazy {
        Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = 2f
            color = Color.GRAY
        }
    }

    init {
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) {
            return
        }
        path.rewind()
        path.moveTo(0f, (height -20).toFloat())
        path.cubicTo(
            (width / 6).toFloat(), (height - 20).toFloat(),
            (width / 3).toFloat(), (height - 20).toFloat(),
            (width / 2).toFloat(), (height - 30).toFloat()
        )

//        path.cubicTo(
//            (width / 3).toFloat(), (height - 20).toFloat(),
//            (width / 2 + 100).toFloat(), (height - 20).toFloat(),
//            width.toFloat(), (height - 10).toFloat()
//        )
        canvas.drawPath(path, paint)
    }
}