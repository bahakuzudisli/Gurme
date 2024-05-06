package com.kuzudisli.gurme

import android.app.Application
import com.kuzudisli.domain.entities.User
import com.kuzudisli.gurme.di.myModule
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GurmeApplication : Application(), KoinComponent {
    companion object {
        lateinit var realm: Realm
    }

    override fun onCreate() {
        super.onCreate()
        initRealm()
        //initWorkManager()  // WorkManager'ı burada başlatın
        startKoin {
            androidLogger(Level.ERROR) // Hata ayıklama için log seviyesi
            androidContext(this@GurmeApplication)
            workManagerFactory() // WorkManager'ı Koin ile kullanmak için
            modules(myModule)
        }

    }

    private fun initRealm() {
        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    User::class
                )
            )
        )
    }
}