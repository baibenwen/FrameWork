package com.example.libserver.http.factory;

import android.os.Message;

import com.example.libcore.Common.Cmd;
import com.example.libserver.http.model.NullRequestParams;
import com.loopj.android.http.RequestParams;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class RequestParamsFactory {
    public static final String TAG = "TAG." + RequestParamsFactory.class.getName();

    public static RequestParams getParams(int cmd, Message message) {
        RequestParams result = new RequestParams();
        switch (cmd) {
            case Cmd.REQUEST_BASE_URL:
                result = new NullRequestParams();
                break;
            default:
                result = new NullRequestParams();
                break;
        }
        return result;
    }
}

