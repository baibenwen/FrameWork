package com.example.libserver.http.factory;

import android.os.Message;

import com.example.libserver.http.model.BaseResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class RequestFactory {
    public static final String TAG = "TAG." + RequestFactory.class.getName();

    int cmd;
    Message params;

    URLFactory urlFactory = new URLFactory();
    RequestParamsFactory paramsFactory = new RequestParamsFactory();
    ResponseHandlerFactory responseHandlerFactory = new ResponseHandlerFactory();

    private String url;
    private RequestParams requestParams;
    private BaseResponseHandler responseHandler;

    public RequestFactory(int cmd, Message params){
        this.cmd = cmd ;
        this.params = params ;
        generate();
    }

    public void generate(){
        url = urlFactory.getUrl(cmd);
        requestParams = paramsFactory.getParams(cmd,params);
        responseHandler = this.responseHandlerFactory.getHandler(cmd);
    }


    public String getUrl(){
        return url;
    }

    public RequestParams getRequestParams() {
        return requestParams;
    }

    public BaseResponseHandler getResponseHandler() {
        return responseHandler;
    }
}
