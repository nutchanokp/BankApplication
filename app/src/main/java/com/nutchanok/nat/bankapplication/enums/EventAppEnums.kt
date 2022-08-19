package com.nutchanok.nat.bankapplication.enums

enum class EventAppEnums(val code: String) {

    FORCE_UPDATE("force"),
    SOFT_UPDATE("soft"),
    MAINTENANCE("maintenance"),
    UNAUTHORIZED("unauthorized"),
    NONE("none");

    companion object {
        fun fromCode(code: String?): EventAppEnums {
            if (code != null) {
                values().find { code.toLowerCase() == it.code.toLowerCase() }?.let {
                    return it
                }
            }
            return NONE
        }
    }
}