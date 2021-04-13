package com.vicky7230.flutter_app;

import android.content.Context;
import android.util.Log;

import com.moengage.core.LogLevel;
import com.moengage.core.MoEngage;
import com.moengage.core.MoEngage.Builder;
import com.moengage.core.config.FcmConfig;
import com.moengage.core.config.InAppConfig;
import com.moengage.core.config.LogConfig;
import com.moengage.core.config.NotificationConfig;
import com.moengage.flutter.MoEInitializer;
import com.moengage.mi.MoEMiPushHelper;
import com.moengage.mi.listener.MiPushEventListener;
import com.xiaomi.mipush.sdk.MiPushMessage;

import io.flutter.app.FlutterApplication;

public class MyApplication extends FlutterApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MoEngage.Builder builder = new Builder(this, "U8RR6TSZPEM5EWFBCZBNJVIJ")
                .configureNotificationMetaData(
                        new NotificationConfig(
                                R.drawable.ic_snow,
                                R.drawable.download,
                                -1,
                                null,
                                true,
                                true,
                                true
                        )
                )
                .configureFcm(new FcmConfig(
                        false
                ))
                .configureInApps(new InAppConfig(
                        false,
                        null
                ))
                .configureLogs(
                        new LogConfig(
                                LogLevel.VERBOSE,
                                true
                        )
                );

        MoEInitializer.initialize(getApplicationContext(), builder);

        /*MoEGeofenceHelper.getInstance().registerGeofenceHitListener(new OnGeofenceHitListener() {
            @Override
            public boolean geofenceHit(Intent geoFenceHit) {
                Log.e("GEOFENCE", "Geofence : " + geoFenceHit.toString());
                return false;
            }
        });*/

        MoEMiPushHelper.Companion.getInstance().setEventListener(new MiPushEventListener() {
            @Override
            public void onNonMoEngageNotificationClicked(Context context, MiPushMessage message) {
                super.onNonMoEngageNotificationClicked(context, message);
            }

            @Override
            public void onNonMoEngagePassThroughMessage(Context context, MiPushMessage message) {
                super.onNonMoEngagePassThroughMessage(context, message);
            }

            @Override
            public void onTokenAvailable(String token) {
                Log.e("TOKEN", "Received Mi Push Token : " + token);
            }
        });
    }
}
