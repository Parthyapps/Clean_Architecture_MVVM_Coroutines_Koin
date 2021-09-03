package com.clean_arch_mvvm_coroutines

import android.app.Application
import androidx.multidex.MultiDex
import com.clean_arch_mvvm_coroutines.di.AppModule
import com.clean_arch_mvvm_coroutines.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    fun OnCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}