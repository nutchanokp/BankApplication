package com.nutchanok.nat.bankapplication.extensions

import android.view.View
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView

/*BottomNavigation*/
fun BottomNavigationView.disableTooltip() {
    menu.forEach {
        val view = findViewById<View>(it.itemId)
        view.setOnLongClickListener {
            true
        }
    }
}