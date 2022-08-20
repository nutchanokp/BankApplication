package com.nutchanok.nat.bankapplication.extensions

import java.text.DecimalFormat


fun Double?.toCurrency(): String {
    return if (this != null) {
        var number = this
        if (number < 0.0) number = 0.0
        val decimal = DecimalFormat("#,##0.00")
        "${decimal.format(number)}"
    } else {
        "0.00"
    }
}

fun String?.toDoublePrice(): Double {
    return this?.replace(",", "")?.replace(" ฿", "")?.toDouble() ?: 0.0
}

fun Double?.toCurrency2(): String {
    return if (this != null) {
        val decimal = DecimalFormat("#,##0.00")
        decimal.format(this)
    } else {
        "-"
    }
}



