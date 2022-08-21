package com.nutchanok.nat.bankapplication.common.manager

import com.nutchanok.nat.bankapplication.common.constant.PaperKey
import com.nutchanok.nat.bankapplication.extensions.getUiText
import io.paperdb.Paper


object LanguageManager {

    const val TH = "th"
    const val EN = "en"

    val closeText
        get() = getUiText("102006", "Close")

    fun setLanguage(code: String) {
        Paper.book().write(PaperKey.LANGUAGE, code)
    }

    fun getLanguage(): String {
        return Paper.book().read(PaperKey.LANGUAGE) ?: TH
    }

    fun getContent(tag: Any?, default: String?): String {
        var result = default ?: ""
        tag?.let {
            val viewTag = tag as String
            AppManager.getUIContents()?.find {
                it.code.equals(viewTag) && it.language.equals(
                    getLanguage(), true
                )
            }?.let {
                if (!it.content.isNullOrEmpty()) {
                    result = it.content!!
                }
            }
        }
        return result
    }

}