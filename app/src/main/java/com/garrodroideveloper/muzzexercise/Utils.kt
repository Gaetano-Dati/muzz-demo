package com.garrodroideveloper.muzzexercise

import java.text.SimpleDateFormat
import java.util.Date

fun Long.convertLongToDayOfTheWeek(): String {
    val date = Date(this)
    val format = SimpleDateFormat("EEEE")
    return format.format(date)
}

fun Long.convertLongToHourOfTheDay(): String {
    val date = Date(this)
    val format = SimpleDateFormat("HH:mm")
    return format.format(date)
}
