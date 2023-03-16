package com.trendnxt.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager


class CustomViewPager :ViewPager {

    private var isPagingEnabled = true

    constructor(context: Context?) : super(context!!) {
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        try {
            return isPagingEnabled && super.onInterceptTouchEvent(event)
        } catch (exception: IllegalArgumentException) {
            exception.printStackTrace()
        }
        return false
    }

    override fun canScroll(v: View?, checkV: Boolean, dx: Int, x: Int, y: Int): Boolean {
        return isPagingEnabled && super.canScroll(v, checkV, dx, x, y)
    }

    fun setPagingEnabled(b: Boolean) {
        isPagingEnabled = b
    }

    override fun removeView(view: View?) {
        super.removeView(view)
    }


    fun getPagingStatus(): Boolean? {
        return isPagingEnabled
    }
}