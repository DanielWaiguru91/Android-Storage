package dev.hashnode.danielwaiguru.androidstorage.utils

import java.text.SimpleDateFormat
import java.util.*

fun getDate(): String {
    val current = System.currentTimeMillis()
    val formatter =  SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return formatter.format(current)
}