package com.example.libserver.http.factory;

import com.example.properties.properties.Properties;
import com.example.libcore.Common.Cmd;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class URLFactory {
    public static final String TAG = "TAG." + URLFactory.class.getName();

    private static final String baseURL = Properties.getBaseUrl();

    public static String getUrl(int cmd) {
        String result = baseURL;
        switch (cmd) {
            case Cmd.REQUEST_BASE_URL:
                result = baseURL;
                break;
            default:
                break;
        }
        return result ;
    }
}
