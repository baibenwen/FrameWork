package com.example.libserver.http.model;

import android.os.Message;

import com.example.libserver.http.observer.IHttpObserver;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class BaseResponseHandler extends AsyncHttpResponseHandler {
    public static final String TAG = "TAG." + BaseResponseHandler.class.getName();
    int cmd;
    IHttpObserver iHttpObserver;
    public synchronized void setObserver(IHttpObserver observer){
        iHttpObserver = observer ;
    }
    public BaseResponseHandler(int cmd){
        this.cmd = cmd;
    }
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            Message message = Message.obtain();
            message.obj = new String(responseBody);
            iHttpObserver.onHttpSuccess(cmd,message);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Message message = Message.obtain();
            message.obj = String.valueOf(responseBody);
            iHttpObserver.onHttpFailed(cmd,message);
    }
}
