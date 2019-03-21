package com.vest.template.sample.selection

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup

class SelecttionGroupLayout : ViewGroup {

    //边缘效果实现
//    var edgeEffect: EdgeEffect? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}