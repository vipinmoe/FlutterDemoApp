package com.vicky7230.flutter_app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.moengage.core.MoEAppStateHelper;
import com.moengage.core.MoECoreHelper;
import com.moengage.core.MoESdkStateHelper;
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

    @Override
    public void onNotificationClick(Activity activity, Bundle payload) {

        //check if the app is in background and killed state and handle via custom code

        //call the below only when you want the sdk to handle the click redirection
        super.onNotificationClick(activity, payload);
    }
}
