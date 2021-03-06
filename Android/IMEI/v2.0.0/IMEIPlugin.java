package com.simonmacdonald.imei;


import org.json.JSONArray;

import android.content.Context;
import android.telephony.TelephonyManager;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;

public class IMEIPlugin extends Plugin {

    @Override
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";

        if (action.equals("get")) {
            TelephonyManager telephonyManager = (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            result = telephonyManager.getDeviceId();
        }
        else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        return new PluginResult(status, result);
    }

}
