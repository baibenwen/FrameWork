package com.example.zhiwen.httptest.observer;

import android.os.Message;

/**
 * Created by zhiwen on 2016/09/25.
 */
public interface ICmdObserver {
    public static final String TAG = "TAG." + ICmdObserver.class.getName();
    void onCmdSuccess(int cmd , Message obj);
    void onCmdFailed(int cmd , Message obj);
}
