package com.sh.sqldelight

import android.app.Application
import com.sh.sqldelight.di.personModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SqlDelightApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SqlDelightApp)
            modules(personModule)
        }

    }
}