package com.example.libserver.http.factory;

import com.example.libcore.Common.Cmd;
import com.example.libserver.http.model.BaseResponseHandler;

/**
 * Created by zhiwen on 2016/09/25.
 */
public class ResponseHandlerFactory {
    public static final String TAG = "TAG." + ResponseHandlerFactory.class.getName();

    int cmd;
    BaseResponseHandler baseResponseHandler;

    public BaseResponseHandler getHandler(int cmd) {
        BaseResponseHandler result = null;
        switch (cmd){
            case Cmd.REQUEST_BASE_URL:
                result = new BaseResponseHandler(cmd);
                break;
        }
        return  result;
    }
}
