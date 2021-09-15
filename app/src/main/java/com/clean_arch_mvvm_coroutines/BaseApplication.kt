package com.clean_arch_mvvm_coroutines

import android.app.Application
import androidx.multidex.MultiDex
import com.clean_arch_mvvm_coroutines.di.AppModule
import com.clean_arch_mvvm_coroutines.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(AppModule, NetworkModule))
        }
    }
}