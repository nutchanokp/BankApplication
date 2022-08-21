package com.nutchanok.nat.bankapplication.common.enums

enum class BankAccountTypeEnum(val type: String, val title: String, val description: String) {

    SAVINGS("SAVINGS", "Savings", "Savings Account"),
    FIXED("FIXED", "Fixed","fixed deposit account"),
    CURRENT("CURRENT", "Current","current account");

    companion object {
        fun fromType(type: String?): BankAccountTypeEnum {
            if (type != null) {
                values().find { type.equals(it.type, true) }?.let {
                    return it
                }
            }
            return SAVINGS
        }
    }
}