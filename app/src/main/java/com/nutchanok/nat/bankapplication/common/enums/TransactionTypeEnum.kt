package com.nutchanok.nat.bankapplication.common.enums

enum class TransactionTypeEnum(val type: String , val desc :String) {

    IN("in","Transfer in"),
    OUT("out","Transfer out"),
    PROMPTPAY("promptpay", "Transfer PromptPay");

    companion object {
        fun fromType(type: String?): TransactionTypeEnum {
            if (type != null) {
                values().find { type.equals(it.type, true) }?.let {
                    return it
                }
            }
            return IN
        }
    }
}