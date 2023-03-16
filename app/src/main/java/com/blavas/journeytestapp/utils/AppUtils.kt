package com.trendnxt.utils

import android.content.Context
import android.net.ConnectivityManager
import java.util.*


class AppUtils {

    companion object {

        @JvmStatic
        fun isNetworkAvailable(context: Context): Boolean {
            val activeNetworkInfo =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        @JvmStatic
        fun getUUID(context: Context): String {
            return UUID.randomUUID().toString()
        }

    }
}