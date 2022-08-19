package com.nutchanok.nat.bankapplication

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import com.nutchanok.nat.bankapplication.manager.AppManager
import com.nutchanok.nat.bankapplication.manager.LanguageManager
import java.util.ArrayList


fun Any.overrideUIText(root: View) {
    AppManager.getUIContents()?.filter {
        it.language.equals(LanguageManager.getLanguage(), true)
    }?.forEach {
        root.getAllChildren().forEach { v ->
            v.tag?.let { tag ->
                val viewTag = tag as String
                if (it.code.equals(viewTag) && !it.content.isNullOrEmpty()) {
                    when (v) {
                        is Button -> {
                            v.text = it.content
                        }
                        is EditText -> {
                            v.hint = it.content
                        }
                        is TextView -> {
                            v.text = it.content
                        }
                        is CheckBox -> {
                            v.text = it.content
                        }
                        is SearchView -> {
                            v.queryHint = it.content
                        }
//                        is SlashToolbar -> {
//                            v.setTitle(it.content)
//                        }
                    }
                }
            }
        }
    }
}


/*view*/
fun View.getAllChildren(): MutableList<View> {
    val result: MutableList<View> = ArrayList()
    if (this !is ViewGroup) {
        result.add(this)
        return result
    }
    val viewGroup = this
    for (i in 0 until viewGroup.childCount) {
        val child = viewGroup.getChildAt(i)
        val viewArrayList: MutableList<View> = ArrayList()
        viewArrayList.add(this)
        viewArrayList.addAll(child.getAllChildren())
        result.addAll(viewArrayList)
    }
    return result
}

fun Any.getUiText(key: String, defText: String): String {
    return LanguageManager.getContent(
        key,
        defText
    )
}

