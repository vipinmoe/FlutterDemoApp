package com.vicky7230.flutter_app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.moengage.core.MoEngage;
import com.moengage.core.internal.logger.Logger;
import com.moengage.core.internal.utils.JsonBuilder;

import com.moengage.plugin.base.push.PluginPushCallback;
import com.moengage.pushbase.model.action.NavigationAction;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyListener extends PluginPushCallback {

    /*Map<String, String> keyMapper = new HashMap<String, String>() {{
        put(PushConstants.IS_DEFAULT_ACTION, ConstantsKt.PARAM_IS_DEFAULT_ACTION);
        put(PushConstants.NAV_ACTION, ConstantsKt.PARAM_CLICKED_ACTION);
    }};

    @Override
    public void onHandleRedirection(Activity activity, Bundle payload) {

        try {
            if (MoEngage.isAppForeground()) {

                Log.e("ERROR :", "Notifcation click will not do anything");

                CallbackHelper.INSTANCE.sendOrQueueEvent(
                        new PushEvent(
                                EventType.PUSH_CLICKED,
                                new PushPayload(pushPayloadToMap(payload))
                        )
                );
                //super.onHandleRedirection(activity, payload);
            } else {
                super.onHandleRedirection(activity, payload);
            }

        } catch (Exception e) {
            Logger.e("$tag onHandleRedirection() : ", e);
        }
    }

    private Map<String, Object> pushPayloadToMap(Bundle bundle) throws JSONException {
        Map map = new HashMap<String, Object>();
        Set<String> keys = bundle.keySet();
        for (String key : keys) {
            if (key == PushConstants.NAV_ACTION) {
                Parcelable parcel = bundle.getParcelable(key);
                if (parcel != null) {
                    NavigationAction navigationAction = (NavigationAction) parcel;
                    map.put(UtilsKt.transform(key, keyMapper), getNavClickActionJson(navigationAction));
                }
            } else {
                Object value = bundle.get(key);
                if (value != null) {
                    map.put(UtilsKt.transform(key, keyMapper), value);
                }
            }
        }
        return map;
    }

    private JSONObject getNavClickActionJson(NavigationAction navigationAction) throws JSONException {
        JsonBuilder clickedJson = new JsonBuilder();
        clickedJson.putString(ConstantsKt.PARAM_ACTION_TYPE, ConstantsKt.ACTION_TYPE_NAVIGATION);
        clickedJson.putJsonObject(ConstantsKt.ARGUMENT_PAYLOAD, UtilsKt.navigationActionToJson(navigationAction));
        return clickedJson.build();
    }*/
}
