package io.github.erikrios.myreportapp

import android.app.Application
import io.github.erikrios.myreportapp.utils.ReleaseTree
import timber.log.Timber

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}