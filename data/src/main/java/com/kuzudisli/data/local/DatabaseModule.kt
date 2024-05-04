package com.kuzudisli.data.local

import io.realm.kotlin.Realm
import org.koin.dsl.module

public val databaseModule2 = module {
    single {
        // Realm database instance
        //Realm.getDefaultInstance()
    }
}