package com.vicky7230.flutter_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.moengage.core.internal.utils.UtilsKt;
import com.moengage.plugin.base.CallbackHelper;
import com.moengage.plugin.base.PluginPushCallback;
import com.moengage.plugin.base.model.EventType;
import com.moengage.plugin.base.model.PushEvent;
import com.moengage.plugin.base.model.PushPayload;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class CustomPushListener extends PluginPushCallback {

    @Override
    public void onHandleRedirection(Activity activity, Bundle payload) {

        //Log.e("Activity : ", activity.getClass().getSimpleName());

        activity.startActivity(new Intent(activity, MainActivity.class));

        Log.e("Payload : ", payload.toString());

        Map<String, Object> map = new HashMap<>();

        if (payload.containsKey("sample_key")) {
            map.put("sample_key", payload.get("sample_key"));
        }

        CallbackHelper.INSTANCE.sendOrQueueEvent(
                new PushEvent(
                        EventType.PUSH_CLICKED,
                        new PushPayload(map)
                )
        );
    }
}
