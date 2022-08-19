package com.nutchanok.nat.bankapplication.config

import androidx.multidex.MultiDexApplication
import com.nutchanok.nat.bankapplication.di.appModule
import io.paperdb.Paper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // Koin
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule))
            androidLogger()
        }

        // Paper
        Paper.init(applicationContext)

    }
}