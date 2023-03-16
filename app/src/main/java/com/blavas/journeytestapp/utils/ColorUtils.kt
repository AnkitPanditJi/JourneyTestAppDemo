package com.trendnxt.utils

import android.graphics.Color

object ColorUtils {

    fun getColor(value : Int) : Int {
        var v: Int = Color.parseColor("#F57E0D")
        if(value == 0)
            v =  Color.parseColor("#F57E0D")
        if(value == 1)
            v =  Color.parseColor("#1A96A6")
        if(value == 2)
            v =  Color.parseColor("#EE002B")
        if(value == 3)
            v =  Color.parseColor("#0D78F5")
        return  v
    }

}