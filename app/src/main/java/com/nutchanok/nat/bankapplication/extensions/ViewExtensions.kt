package com.nutchanok.nat.bankapplication.extensions

import android.view.View
import android.widget.ImageView
import androidx.core.view.forEach
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
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

fun ImageView.loadImage(resId: Int) {
    try {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(context).load(resId).apply(requestOptions).into(this)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
