package com.apps.madnotdead.notiapp

import android.app.Application
import android.R.attr.start
import com.microsoft.azure.mobile.MobileCenter
import com.microsoft.azure.mobile.analytics.Analytics
import com.microsoft.azure.mobile.crashes.Crashes
import com.microsoft.azure.mobile.push.Push;


/**
 * Created by leandrom on 10/6/2017.
 */
class ThisApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MobileCenter.start(this, "6382b2f1-5d3c-44ca-80bf-3ea7c5f6c5be",
                Analytics::class.java, Crashes::class.java, Push::class.java)

    }
}