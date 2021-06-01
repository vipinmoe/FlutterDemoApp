package com.vicky7230.flutter_app;

import android.app.Activity;
import android.os.Bundle;

import com.moengage.core.MoEngage;
import com.moengage.plugin.base.CallbackHelper;
import com.moengage.plugin.base.PluginPushCallback;
import com.moengage.plugin.base.model.EventType;
import com.moengage.plugin.base.model.PushEvent;
import com.moengage.plugin.base.model.PushPayload;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends PluginPushCallback {

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
