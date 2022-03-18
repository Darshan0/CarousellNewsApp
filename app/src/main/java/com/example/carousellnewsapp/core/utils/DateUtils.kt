package com.example.carousellnewsapp.core.utils

import java.time.Duration
import java.util.*

private fun currentDate(): Date {
    val calendar = Calendar.getInstance()
    return calendar.time
}

fun getTimeAgo(date: Date): String {

    val oneSec = 1000L
    val oneMin: Long = 60 * oneSec
    val oneHour: Long = 60 * oneMin
    val oneDay: Long = 24 * oneHour
    val oneMonth: Long = 30 * oneDay
    val oneYear: Long = 365 * oneDay

    var time = date.time
    if (time < 1000000000000L) {
        time *= 1000
    }

    val now = currentDate().time
    if (time > now || time <= 0) {
        return "in the future"
    }
    val diff = now - time

    val diffMin: Long = diff / oneMin
    val diffHours: Long = diff / oneHour
    val diffDays: Long = diff / oneDay
    val diffMonths: Long = diff / oneMonth
    val diffYears: Long = diff / oneYear

    return when {
        diffYears > 0 -> "$diffYears years ago"
        diffMonths > 0 && diffYears < 1 -> "${(diffMonths - diffYears / 12)} months ago "
        diffDays > 0 && diffMonths < 1 -> "${(diffDays - diffMonths / 30)} days ago "
        diffHours > 0 && diffDays < 1 -> " ${(diffHours - diffDays * 24)} hours ago "
        diffMin > 0 && diffHours < 1 -> " ${(diffMin - diffHours * 60)} min ago "
        else -> "moments ago"
    }
}