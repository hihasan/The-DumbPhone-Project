package com.dumbphone.dumbphone.utils;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class DumbApplication extends Application {
    private static final String WIFI_STATE_CHANGE_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    private static Context context;

    public void onCreate() {
        super.onCreate();

        DumbApplication.context = getApplicationContext();
        registerForNetworkChangeEvents(this);
    }

    public static Context getAppContext() {
        return DumbApplication.context;
    }

    public static String getResourceString(int resourceId){
        Context appContext = getAppContext();
        if(appContext == null) return null;
        Resources resources = appContext.getResources();
        return resources.getString(resourceId);
    }

    public static void registerForNetworkChangeEvents(final Context context) {
        NetworkStateChangeReceiver networkStateChangeReceiver = new NetworkStateChangeReceiver();
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(WIFI_STATE_CHANGE_ACTION));
    }
}
