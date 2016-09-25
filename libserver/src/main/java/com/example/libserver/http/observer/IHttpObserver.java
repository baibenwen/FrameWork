package com.example.libserver.http.observer;

import android.os.Message;

/**
 * Created by zhiwen on 2016/09/25.
 */
public interface IHttpObserver {
    void onHttpSuccess(int cmd, Message obj);
    void onHttpFailed(int cmd, Message obj);
}
