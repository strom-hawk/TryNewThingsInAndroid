package com.example.trynewthingsinandroid

import android.app.Application
import com.example.trynewthingsinandroid.base.ReleaseTree
import timber.log.Timber

class MyApplication(): Application() {

    override fun onCreate() {
        super.onCreate()
        initializeTimber()
    }

    private fun initializeTimber() {
        Timber.plant(if(BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree())
    }
}