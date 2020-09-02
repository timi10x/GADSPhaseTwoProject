package com.expansetech.gadsphasetwoproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils {
    companion object {
        fun isOnline(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}