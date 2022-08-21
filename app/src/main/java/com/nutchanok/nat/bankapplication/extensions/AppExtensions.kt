//package com.nutchanok.nat.bankapplication.extensions
//
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.CheckBox
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.widget.SearchView
//import com.nutchanok.nat.bankapplication.common.manager.AppManager
//import com.nutchanok.nat.bankapplication.common.manager.LanguageManager
//import java.util.ArrayList
//
///*view*/
//fun View.getAllChildren(): MutableList<View> {
//    val result: MutableList<View> = ArrayList()
//    if (this !is ViewGroup) {
//        result.add(this)
//        return result
//    }
//    val viewGroup = this
//    for (i in 0 until viewGroup.childCount) {
//        val child = viewGroup.getChildAt(i)
//        val viewArrayList: MutableList<View> = ArrayList()
//        viewArrayList.add(this)
//        viewArrayList.addAll(child.getAllChildren())
//        result.addAll(viewArrayList)
//    }
//    return result
//}
//
//
