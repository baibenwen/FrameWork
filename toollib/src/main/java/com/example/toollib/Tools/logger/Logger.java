package com.example.toollib.Tools.logger;

import android.util.Log;

import com.example.properties.properties.Properties;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class Logger {
    private static boolean isOpen = Properties.isDebugOpen();

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public static void d(String tag,String d){
        if (isOpen){
            Log.d(tag,d);
        }
    }
}
