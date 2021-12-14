package com.vmd.examen

import android.app.Application
import com.vmd.examen.di.repositoryModule
import com.vmd.examen.di.retrofitModule
import com.vmd.examen.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExamApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExamApplication)
            modules(retrofitModule, repositoryModule, viewModelModule)
        }
    }
}