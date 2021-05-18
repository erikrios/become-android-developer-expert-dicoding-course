package io.github.erikrios.mymaps

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_acess_token))
    }
}