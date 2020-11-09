package com.vicky7230.flutter_app;

import com.moengage.core.Logger;
import com.moengage.core.MoEngage;
import com.moengage.core.MoEngage.Builder;
import com.moengage.flutter.MoEInitializer;

import io.flutter.app.FlutterApplication;

public class MyApplication extends FlutterApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MoEngage.Builder builder = new Builder(this, "U8RR6TSZPEM5EWFBCZBNJVIJ")
                .setNotificationSmallIcon(R.drawable.ic_snow)
                .setNotificationLargeIcon(R.drawable.download)
                .optOutDefaultInAppDisplay()
                .setLogLevel(Logger.VERBOSE)
                .enableMultipleNotificationInDrawer()
                .optOutTokenRegistration();

        MoEInitializer.initialize(getApplicationContext(), builder);
    }
}
