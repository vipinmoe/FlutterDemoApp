package com.vicky7230.flutter_app;

import android.content.Intent;
import android.util.Log;

import android.content.Context;

import com.moengage.core.Logger;
import com.moengage.core.MoEngage;
import com.moengage.core.MoEngage.Builder;
import com.moengage.flutter.MoEInitializer;
import com.moengage.geofence.MoEGeofenceHelper;
import com.moengage.geofence.listener.OnGeofenceHitListener;

import com.moengage.mi.MoEMiPushHelper;
import com.moengage.mi.listener.MiPushEventListener;
import com.xiaomi.mipush.sdk.MiPushMessage;

import io.flutter.app.FlutterApplication;

public class MyApplication extends FlutterApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MoEngage.Builder builder = new Builder(this, "U8RR6TSZPEM5EWFBCZBNJVIJ")
                .configureMiPush("2882303761518810740", "5881881071740", true)
                .enablePushKitTokenRegistration()
                .setNotificationSmallIcon(R.drawable.ic_snow)
                .setNotificationLargeIcon(R.drawable.download)
                .optOutDefaultInAppDisplay()
                .setLogLevel(Logger.VERBOSE)
                .enableMultipleNotificationInDrawer()
                .enableLocationServices()
                .optOutTokenRegistration();

        MoEInitializer.initialize(getApplicationContext(), builder);

        MoEGeofenceHelper.getInstance().registerGeofenceHitListener(new OnGeofenceHitListener() {
            @Override
            public boolean geofenceHit(Intent geoFenceHit) {
                Log.e("GEOFENCE", "Geofence : " + geoFenceHit.toString());
                return false;
            }
        });

        MoEMiPushHelper.Companion.getInstance().setEventListener(new MiPushEventListener(){
            @Override
            public void onNonMoEngageNotificationClicked(Context context, MiPushMessage message) {
                super.onNonMoEngageNotificationClicked(context, message);
            }

            @Override
            public void onNonMoEngagePassThroughMessage(Context context,MiPushMessage message) {
                super.onNonMoEngagePassThroughMessage(context, message);
            }

            @Override
            public void onTokenAvailable(String token) {
                Log.e("TOKEN","Received Mi Push Token : "+token);
            }
        });
    }
}
