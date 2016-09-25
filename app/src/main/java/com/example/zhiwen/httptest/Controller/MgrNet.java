package com.example.zhiwen.httptest.Controller;

import android.os.Message;


import com.example.libserver.http.NetWrapper;
import com.example.libserver.http.observer.IHttpObserver;

import java.util.ArrayList;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class MgrNet implements IHttpObserver {
    public static final String TAG = "TAG." + MgrNet.class.getName();

    private ArrayList<IHttpObserver> observers = new ArrayList<>();

    public synchronized void addHttpObserver(IHttpObserver observer){
        observers.add(observer);
    }

    public synchronized void removeHttpObserver(IHttpObserver observer){
        observers.remove(observer);
    }


    public void post(int cmd , Message params){
        NetWrapper netWrapper = new NetWrapper(cmd, params);
        netWrapper.request(this);
    }

    @Override
    public void onHttpSuccess(int cmd, Message obj) {
        for (IHttpObserver observer : observers) {
            observer.onHttpSuccess(cmd, obj);
        }
    }

    @Override
    public void onHttpFailed(int cmd, Message obj) {
        for (IHttpObserver observer : observers) {
            observer.onHttpFailed(cmd, obj);
        }
    }
}
