package com.kuzudisli.data.local

import org.koin.dsl.module

public val databaseModule = module {
    single {
        // Realm database instance
        //Realm.getDefaultInstance()
    }
}