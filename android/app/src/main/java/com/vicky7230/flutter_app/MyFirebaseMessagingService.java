package com.vicky7230.flutter_app;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.moengage.firebase.MoEFireBaseHelper;
import com.moengage.pushbase.MoEPushHelper;

/*
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.e(TAG, "Notification received : " + remoteMessage.getData().toString());
        if (!remoteMessage.getData().isEmpty()) {
            Log.e(TAG, "Passing Notification Data to MoEngage SDK");
            if (MoEPushHelper.getInstance().isFromMoEngagePlatform(remoteMessage.getData())) {
                //MoEPushHelper.getInstance().handlePushPayload(getApplicationContext(), remoteMessage.getData());
                MoEFireBaseHelper.Companion.getInstance().passPushPayload(getApplicationContext(), remoteMessage.getData());
            }
        }
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.e(TAG, "Token received, passing to Moengage SDK : " + token);
        //PushManager.getInstance().refreshToken(getApplicationContext(), token);
        MoEFireBaseHelper.Companion.getInstance().passPushToken(getApplicationContext(), token);
    }

}*/
