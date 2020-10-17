package com.example.core.utility

import android.text.format.DateFormat
import java.util.*

fun Long.toDateFormat(pattern: String): String {
    val calendar = Calendar.getInstance().also {cal ->
        cal.timeInMillis = this * 1000
    }
    return DateFormat.format(pattern, calendar).toString()
}

