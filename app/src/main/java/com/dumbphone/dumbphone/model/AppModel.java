package com.dumbphone.dumbphone.model;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class AppModel {
    private String appname = "";
    private String pname = "";
    private String versionName = "";
    private int versionCode = 0;
    private Drawable icon;

    public AppModel(){

    }
    private void prettyPrint() {
        Log.v("HIHASAN", appname + "\t" + pname + "\t" + versionName + "\t" + versionCode);
    }
}
