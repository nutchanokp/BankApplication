package com.nutchanok.nat.bankapplication.extensions

import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


enum class DateFormat(val format: String) {
    SHOW("dd MMM yyyy - HH:mm"),
    FROM_SERVICE("yyyy-MM-dd"),
    FROM_SERVICE_TIME("yyyy-MM-dd HH:mm:ss"),
}

fun String.toDateFormat(currentFormat: DateFormat, toFormat: DateFormat): String {
    return convertDate(this, currentFormat, toFormat)
}

fun getAppCurrentLocale(): Locale {
//    val locale = when (LanguageManager.instance().getCurrentAppLanguage()) {
//        LanguageEnum.EN -> Locale.US
//        LanguageEnum.TH -> Locale("th", "TH")
//    }
    return Locale.US
}

private fun convertDate(input: String, currentFormat: DateFormat, toFormat: DateFormat): String {
    return convertDate(input, currentFormat, toFormat, null)
}

private fun convertDate(
    input: String,
    currentFormat: DateFormat,
    toFormat: DateFormat,
    timeZone: TimeZone?
): String {
    val locale = getAppCurrentLocale()
    val inFormat = SimpleDateFormat(currentFormat.format, getAppCurrentLocale())
    val date = inFormat.parse(input)
    val outFormat = SimpleDateFormat(toFormat.format, locale)
    return outFormat.format(date)
}

fun Date.toDateSendService(): String {
    val locale = getAppCurrentLocale()
    val format = SimpleDateFormat(DateFormat.FROM_SERVICE.format, locale)
    return format.format(this)
}

fun String.toCalendarFromServiceFormatTime(): Calendar {
    val locale = getAppCurrentLocale()
    val cal = Calendar.getInstance()
    val inFormat = SimpleDateFormat(DateFormat.FROM_SERVICE_TIME.format, locale)
    val date = inFormat.parse(this)
    cal.time = date
    return cal
}


fun String.toCalendarFromService(): Calendar {
    val cal = Calendar.getInstance()
    val inFormat = SimpleDateFormat(DateFormat.FROM_SERVICE.format, Locale.US)
    val date = inFormat.parse(this)
    cal.time = date
    return cal
}

fun Any.getDatePart(date: Date): Calendar {
    val cal = Calendar.getInstance()       // get calendar instance
    cal.time = date
    cal.set(Calendar.HOUR_OF_DAY, 0)            // set hour to midnight
    cal.set(Calendar.MINUTE, 0)                 // set minute in hour
    cal.set(Calendar.SECOND, 0)                 // set second in minute
    cal.set(Calendar.MILLISECOND, 0)            // set millisecond in second
    return cal                                  // return the date part
}


fun Any.daysBetween(startDate: Date, endDate: Date): Int {
    val sDate = getDatePart(startDate)
    val eDate = getDatePart(endDate)
    var daysBetween: Int = 0
    while (sDate.before(eDate)) {
        sDate.add(Calendar.DAY_OF_MONTH, 1)
        daysBetween++
    }
    return daysBetween
}

fun DatePicker.getDate(): String {
    val day = this.dayOfMonth
    val month = this.month
    val year = this.year
    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    return calendar.time.toDateSendService()
}

fun Any.getDifferenceDays(stat: Long, end: Long): Long {
    val diff = end - stat
    return TimeUnit.DAYS.convert(
        diff,
        TimeUnit.MILLISECONDS
    )
}

