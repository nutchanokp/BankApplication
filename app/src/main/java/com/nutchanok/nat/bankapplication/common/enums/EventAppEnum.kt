package com.nutchanok.nat.bankapplication.common.enums

enum class EventAppEnum(val code: String) {

    FORCE_UPDATE("force"),
    SOFT_UPDATE("soft"),
    MAINTENANCE("maintenance"),
    UNAUTHORIZED("unauthorized"),
    NONE("none");

    companion object {
        fun fromCode(code: String?): EventAppEnum {
            if (code != null) {
                values().find { code.equals(it.code, ignoreCase = true) }?.let {
                    return it
                }
            }
            return NONE
        }
    }
}