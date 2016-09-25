package com.example.toollib.Tools.Appinfo;

import android.content.Context;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class Information {
    public static final String TAG = "TAG." + Information.class.getName();
    private Object information;

    public Information(Context context) {

    }

    public Object getInformation() {
        return information;
    }
}
