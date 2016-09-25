package com.example.libserver.http;

import android.os.Message;

import com.example.libserver.http.factory.RequestFactory;
import com.example.libserver.http.model.BaseResponseHandler;
import com.example.libserver.http.observer.IHttpObserver;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


/**
 * Created by zhiwen on 2016/09/25.
 */
public class NetWrapper  {
    public static final String TAG = "TAG." + NetWrapper.class.getName();

    public enum RequestType{
        POST,
        GET,
        PUT
    }

    RequestFactory requestFactory ;
    RequestType requestType;

    private static AsyncHttpClient client = new AsyncHttpClient();

    int cmd ;
    Message params;

    public NetWrapper(int cmd, Message params) {
        this.cmd = cmd;
        this.params = params;
        requestType = RequestType.GET;
    }

    public void request(IHttpObserver iHttpObserver){
        requestFactory = new RequestFactory(cmd,params);
        String url = requestFactory.getUrl() ;
        RequestParams params = requestFactory.getRequestParams();
        BaseResponseHandler handler = requestFactory.getResponseHandler();
        handler.setObserver(iHttpObserver);
        switch (requestType){
            case POST:
                post(url , params , handler);
                break;
            case GET:
                get(url,params,handler);
                break;
            case PUT:
                break;
        }
    }


    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }



}
