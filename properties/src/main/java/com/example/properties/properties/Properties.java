package com.example.properties.properties;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class Properties {
    public static final String TAG = "TAG." + Properties.class.getName();

    static String BaseUrl = "http://www.baidu.com";
    static boolean debugOpen = true ;

    public static String getBaseUrl() {
        return BaseUrl;
    }

    public static boolean isDebugOpen() {
        return debugOpen;
    }
}
