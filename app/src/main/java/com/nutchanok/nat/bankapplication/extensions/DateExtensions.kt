//package com.nutchanok.nat.bankapplication.extensions
//
//import android.widget.DatePicker
//import com.nutchanok.nat.bankapplication.enums.LanguageEnum
//import java.text.SimpleDateFormat
//import java.util.*
//import java.util.concurrent.TimeUnit
//
//
//enum class DateFormat(val format: String) {
//    FULL_NAME_MONTH("MMMM"),
//    FULL_NAME_DAY("EEEE"),
//    NAME_DAY("EE"),
//    NAME_MONTH("MMM"),
//    DAY("dd"),
//    MONTH("MMM"),
//    YEAR("YYYY"),
//    TIME("HH:mm"),
//    TIME_AM_PM("hh:mm aa"),
//    TIME_HOUR_MINUTE("HH:mm:ss"),
//    TIME_12("H:m"),
//    TIME_MINUTE("mm:ss"),
//    DATE_TIME_NO_SEC("yyyy-MM-dd HH:mm"),
//    DATE_TIME_HOUR("dd/MM/yyyy HH:mm"),
//    SHOW("dd/MM/yyyy"),
//    SHOW_REPORT("dd.MM.yyyy"),
//    FROM_SERVICE("yyyy-MM-dd"),
//    FROM_SERVICE_TIME("yyyy-MM-dd HH:mm:ss"),
//    DAY_MONTH_NOT_HYPHEN("dd MMM"),
//    DAY_MONTH_YEAR_NOT_HYPHEN("dd MMM yyyy"),
//    DAY_FULL_MONTH_YEAR_NOT_HYPHEN("dd MMMM yyyy"),
//    FULL_DATE("EEEE dd MMMM yyyy "),
//    DASH("yyyy-MM-dd-HH-MM-ss"),
//    UNDERSCORE("yyyy_MM_dd_HH_mm_ss")
//}
//
///*Date*/
//fun String.toDayOnly(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.DAY)
//}
//
//fun String.toShowDate(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.SHOW)
//}
//
//fun String.toYearOnly(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.YEAR)
//}
//
//fun String.toNameDay(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.NAME_DAY)
//}
//
//fun String.toNameMonth(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.NAME_MONTH)
//}
//
//fun String.toFullNameMonth(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE, DateFormat.FULL_NAME_MONTH)
//}
//
//fun String.toDateFormat(currentFormat: DateFormat, toFormat: DateFormat): String {
//    return convertDate(this, currentFormat, toFormat)
//}
//
///*Time*/
//fun Int.secToTime(): String {
//    val calendar = Calendar.getInstance()
//    calendar.timeInMillis = this.toLong()
//    return calendar.time.toDateFormat(DateFormat.TIME)
//}
//
//fun String.toTime(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE_TIME, DateFormat.TIME)
//}
//
//fun String.toTimeAMPM(): String {
//    return convertDate(this, DateFormat.FROM_SERVICE_TIME, DateFormat.TIME_AM_PM)
//}
//
//fun String.to24Time(): String {
//    return convertDate(this, DateFormat.TIME_12, DateFormat.TIME)
//}
//
//fun getAppCurrentLocale(): Locale {
//    val locale = when (UILanguageManager.instance().getCurrentAppLanguage()) {
//        LanguageEnum.EN -> Locale.US
//        LanguageEnum.TH -> Locale("th", "TH")
//    }
//    return locale
//}
//
//private fun convertDate(input: String, currentFormat: DateFormat, toFormat: DateFormat): String {
//    return convertDate(input, currentFormat, toFormat, null)
//}
//
//private fun convertDate(
//    input: String,
//    currentFormat: DateFormat,
//    toFormat: DateFormat,
//    timeZone: TimeZone?
//): String {
//    val locale = getAppCurrentLocale()
//    val inFormat = SimpleDateFormat(currentFormat.format, getAppCurrentLocale())
//    val date = inFormat.parse(input)
//    val outFormat = SimpleDateFormat(toFormat.format, locale)
//    return outFormat.format(date)
//}
//
///** ex : 10 minute **/
//fun Any?.timeBetweenDate(startDate: String, endDate: String): String {
//    return timeBetweenDate(startDate, endDate, false)
//}
//
///** ex : 1.5 **/
//fun Any?.timeBetweenDate(startDate: String, endDate: String, isTimeOnly: Boolean): String {
//    val calStartDate = startDate.toCalendarFromServiceFormatTime()
//    val calEndDate = endDate.toCalendarFromServiceFormatTime()
//
//    val diff = calEndDate.time.time - calStartDate.time.time
//    val seconds = (diff / 1000)
//    val minutes = seconds / 60
//    val hours = minutes / 60
//    val days = hours / 24
//
//    val ui = UILanguageManager.instance()
//    val txtMinute = ui.getUIText("4020108")
//    val txtMinutes = ui.getUIText("4020109")
//    val txtHour = ui.getUIText("4020106")
//    val txtHours = ui.getUIText("4020107")
//    val txtDay = ui.getUIText("2040113")
//
//    val txtM = if (minutes > 1) txtMinutes else txtMinute
//    val txtH = if (hours > 1) txtHours else txtHour
//
//    return if (isTimeOnly) {
//        val result = minutes / 60F
//        result.toString()
//    } else {
//        if (seconds in 1..59) {
//            "1 $txtMinute"
//        } else if (minutes in 1..59) {
//            "$minutes $txtM"
//        } else if (minutes > 60) {
//            val subMinutes = minutes - (hours * 60)
//            if (subMinutes > 0) {
//                val txtSubM = if (subMinutes > 1) txtMinutes else txtMinute
//                "$hours $txtH $subMinutes $txtSubM"
//            } else {
//                "$hours $txtH"
//            }
//        } else {
//            "$days $txtDay"
//        }
//    }
//}
//
//fun getSecond(hour: Int, minute: Int): Int {
//    return (60 * minute) + (3600 * hour)
//}
//
//fun Date.toDateFormat(dateFormat: DateFormat, timeZone: TimeZone): String {
//    val locale = getAppCurrentLocale()
//    val format = SimpleDateFormat(dateFormat.format, locale)
//    format.timeZone = timeZone
//    return format.format(this)
//}
//
//fun Date.toDateFormat(dateFormat: DateFormat): String {
//    val locale = getAppCurrentLocale()
//    val format = SimpleDateFormat(dateFormat.format, locale)
//    return format.format(this)
//}
//
//fun Date.toDateSendService(): String {
//    val locale = getAppCurrentLocale()
//    val format = SimpleDateFormat(DateFormat.FROM_SERVICE.format, locale)
//    return format.format(this)
//}
//
//fun Date.toDateTimeSendService(): String {
//    val locale = getAppCurrentLocale()
//    val format = SimpleDateFormat(DateFormat.FROM_SERVICE_TIME.format, locale)
//    return format.format(this)
//}
//
//fun String.toCalendarFromServiceFormatTime(): Calendar {
//    val locale = getAppCurrentLocale()
//    val cal = Calendar.getInstance()
//    val inFormat = SimpleDateFormat(DateFormat.FROM_SERVICE_TIME.format, locale)
//    val date = inFormat.parse(this)
//    cal.time = date
//    return cal
//}
//
//fun String.toCalendarFromServiceHHMM(): Calendar {
//    val cal = Calendar.getInstance()
//    val inFormat = SimpleDateFormat(DateFormat.TIME.format, Locale.US)
//    val date = inFormat.parse(this)
//    cal.time = date
//    return cal
//}
//
//
//fun String.toCalendarFromService(): Calendar {
//    val cal = Calendar.getInstance()
//    val inFormat = SimpleDateFormat(DateFormat.FROM_SERVICE.format, Locale.US)
//    val date = inFormat.parse(this)
//    cal.time = date
//    return cal
//}
//
//fun Any.getDatePart(date: Date): Calendar {
//    val cal = Calendar.getInstance()       // get calendar instance
//    cal.time = date
//    cal.set(Calendar.HOUR_OF_DAY, 0)            // set hour to midnight
//    cal.set(Calendar.MINUTE, 0)                 // set minute in hour
//    cal.set(Calendar.SECOND, 0)                 // set second in minute
//    cal.set(Calendar.MILLISECOND, 0)            // set millisecond in second
//    return cal                                  // return the date part
//}
//
//
//fun Any.daysBetween(startDate: Date, endDate: Date): Int {
//    val sDate = getDatePart(startDate)
//    val eDate = getDatePart(endDate)
//    var daysBetween: Int = 0
//    while (sDate.before(eDate)) {
//        sDate.add(Calendar.DAY_OF_MONTH, 1)
//        daysBetween++
//    }
//    return daysBetween
//}
//
//fun String.toTimeStamp(): String {
//    val offerTime = this.toCalendarFromServiceFormatTime()
//    val now = Calendar.getInstance(TimeZone.getDefault())
//    now.set(Calendar.MILLISECOND, 0)
//    now.set(Calendar.SECOND, 0)
//
//    val value: Int
//    val unit: String
//
//    val year = now.get(Calendar.YEAR) - offerTime.get(Calendar.YEAR)
//    val month = now.get(Calendar.MONTH) - offerTime.get(Calendar.MONTH)
//    val day = now.get(Calendar.DATE) - offerTime.get(Calendar.DATE)
//    val hour = now.get(Calendar.HOUR) - offerTime.get(Calendar.HOUR)
//    val minute = now.get(Calendar.MINUTE) - offerTime.get(Calendar.MINUTE)
//
//    when {
//        year > 0 -> {
//            value = year
//            unit = getUiText("700013", "year ago")
//        }
//        month > 0 -> {
//            value = month
//            unit = getUiText("700012", "month ago")
//        }
//        day > 0 -> {
//            value = day
//            unit = getUiText("700010", "day ago")
//        }
//        hour > 0 -> {
//            value = hour
//            unit = getUiText("700009", "hour ago")
//        }
//        minute > 0 -> {
//            value = minute
//            unit = getUiText("700008", "minute ago")
//        }
//        else -> return getUiText("700005", "just now")
//    }
//    return String.format("%s %s", value, unit)
//}
//
//fun DatePicker.getDate(): String {
//    val day = this.dayOfMonth
//    val month = this.month
//    val year = this.year
//    val calendar = Calendar.getInstance()
//    calendar.set(year, month, day)
//    return calendar.time.toDateSendService()
//}
//
//fun Any.getDifferenceDays(stat: Long, end: Long): Long {
//    val diff = end - stat
//    return TimeUnit.DAYS.convert(
//        diff,
//        TimeUnit.MILLISECONDS
//    )
//}
//
