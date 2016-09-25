package com.example.zhiwen.httptest.Controller;

import android.os.Message;

import com.example.libserver.http.observer.IHttpObserver;
import com.example.zhiwen.httptest.observer.ICmdObserver;

import java.util.ArrayList;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class MgrSystem implements ICmdObserver, IHttpObserver {
    private static MgrSystem mgrSystem = new MgrSystem();

    public static MgrSystem getInstance() {
        return mgrSystem;
    }

    private ArrayList<ICmdObserver> observers = new ArrayList<>();

    MgrNet mgrNet ;
    public MgrSystem() {
        initMgrNet();
    }

    private void initMgrNet() {
        mgrNet = new MgrNet();
        mgrNet.addHttpObserver(this);
    }


    public boolean postCmd(int cmd, Message obj){
        boolean result = true;
        mgrNet.post(cmd,obj);
        return result;
    }

    public boolean sendCmd(int cmd , Message obj){
        boolean result = true;
        return result;
    }

    public synchronized void addCmdObserver(ICmdObserver observer){
        observers.add(observer);
    }

    public synchronized void removeCmdObserver(ICmdObserver observer){
        observers.remove(observer);
    }

    @Override
    public void onCmdSuccess(int cmd, Message obj) {
        for (ICmdObserver observer : observers) {
            observer.onCmdSuccess(cmd,obj);
        }
    }

    @Override
    public void onCmdFailed(int cmd, Message obj) {
        for (ICmdObserver observer : observers) {
            observer.onCmdFailed(cmd,obj);
        }
    }

    @Override
    public void onHttpSuccess(int cmd, Message obj) {
        onCmdSuccess(cmd,obj);
    }

    @Override
    public void onHttpFailed(int cmd, Message obj) {
        onCmdFailed(cmd,obj);
    }
}
