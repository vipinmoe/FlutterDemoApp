package com.vicky7230.flutter_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.moengage.core.MoEngage;
import com.moengage.plugin.base.CallbackHelper;
import com.moengage.plugin.base.PluginPushCallback;
import com.moengage.plugin.base.model.EventType;
import com.moengage.plugin.base.model.PushEvent;
import com.moengage.plugin.base.model.PushPayload;
import com.moengage.pushbase.model.NotificationPayload;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends PluginPushCallback {

    @NonNull
    @Override
    public NotificationCompat.Builder onCreateNotification(Context context, NotificationPayload notificationPayload) {
        NotificationCompat.Builder builder = super.onCreateNotification(context, notificationPayload);

        builder.setDefaults(NotificationCompat.DEFAULT_SOUND | NotificationCompat.DEFAULT_VIBRATE)
                .setPriority(NotificationCompat.PRIORITY_MAX);

        return builder;
    }

    @Override
    public void onHandleRedirection(Activity activity, Bundle payload) {
        if (MoEngage.isAppForeground()) {
            Map<String, String> myMap = new HashMap<>();
            myMap.put("test123", "dkfasdnaf");
            CallbackHelper.INSTANCE.sendOrQueueEvent(
                    new PushEvent(
                            EventType.PUSH_CLICKED,
                            new PushPayload(myMap)
                    )
            );
        } else {
            super.onHandleRedirection(activity, payload);
        }
    }
}
