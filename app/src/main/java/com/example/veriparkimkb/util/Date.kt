package com.example.veriparkimkb.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date

object Date {
    @SuppressLint("SimpleDateFormat")
    fun isLifetimeValid(lifetimeString: String):Boolean{
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
        val currentTime: Date = Calendar.getInstance().time
        val lifetime = sdf.parse(lifetimeString)
        return currentTime.before(lifetime)
    }
}