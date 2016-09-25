package com.example.zhiwen.httptest.activity;

import android.app.Application;
import android.os.Message;

import com.example.zhiwen.httptest.Controller.MgrSystem;
import com.example.libserver.http.observer.IHttpObserver;
import com.example.zhiwen.httptest.observer.ICmdObserver;

/**
 * Created by zhiwen on 2016/09/25.
 */

public class BaseApplication extends Application {

    private MgrSystem mgrSystem;

    @Override
    public void onCreate() {
        super.onCreate();

        mgrSystem = new MgrSystem();
    }

    public void postCmd(int cmd , Message obj){
        mgrSystem.postCmd(cmd,obj);
    }

    public void addCmdObserver(ICmdObserver iCmdObserver){
        mgrSystem.addCmdObserver(iCmdObserver);
    }

    public void addHttpCmdObserver(IHttpObserver iHttpObserver){
    }

}
