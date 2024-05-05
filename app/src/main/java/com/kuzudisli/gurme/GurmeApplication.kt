package com.kuzudisli.gurme

import android.app.Application
import com.kuzudisli.gurme.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GurmeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR) // Hata ayıklama için log seviyesi
            androidContext(this@GurmeApplication)
            modules(myModule)
        }
    }
}