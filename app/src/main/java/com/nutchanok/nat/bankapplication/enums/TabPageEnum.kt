package com.nutchanok.nat.bankapplication.enums


enum class TabPageEnum(val text: String, val code: String) {
    NEW_ORDER("ออเดอร์", "104003"),
    MANAGE_TABLE("", ""),
    HISTORY("ประวัติการสั่ง", "104004"),
    MENUS("รายการอาหาร", "104005"),
    PROFILE("บัญชีผู้ใช้", "104006")
}

//fun TabPageEnum.getText() = getUiText(code, text)