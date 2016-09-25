package com.example.zhiwen.httptest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;

import com.example.zhiwen.httptest.observer.ICmdObserver;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class BaseActivity extends Activity implements ICmdObserver {

    public static final String TAG = "TAG."+BaseActivity.class.getName();
    BaseApplication app ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (BaseApplication) getApplication();
        app.addCmdObserver(this);
    }

    public void postCmd(int cmd , Message obj){
        app.postCmd(cmd,obj);
    }

    public void postCmd(int cmd){
        postCmd(cmd,null);
    }

    @Override
    public void onCmdSuccess(int cmd, Message obj) {

    }

    @Override
    public void onCmdFailed(int cmd, Message obj) {

    }
}
