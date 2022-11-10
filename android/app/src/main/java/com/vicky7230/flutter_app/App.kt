package com.vicky7230.flutter_app

import android.app.Application
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.InAppConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.flutter.MoEInitializer

class App : Application() {


    fun funny() {
        val builder = MoEngage.Builder(this, "U8RR6TSZPEM5EWFBCZBNJVIJ")
            .configureLogs(
                LogConfig(
                    LogLevel.VERBOSE,
                    true
                )
            )

        MoEInitializer.initialiseDefaultInstance(applicationContext, builder)
    }

}