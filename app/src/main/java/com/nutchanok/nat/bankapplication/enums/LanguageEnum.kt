package com.nutchanok.nat.bankapplication.enums

enum class LanguageEnum(val language: String) {

    TH("th"),
    EN("en");

    companion object {
        fun from(language: String?): LanguageEnum {
            if (language != null) {
                values().find { language.equals(it.language, true) }?.let {
                    return it
                }
            }
            return TH
        }
    }
}