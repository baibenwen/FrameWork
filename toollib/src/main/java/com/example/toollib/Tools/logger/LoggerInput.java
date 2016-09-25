package com.example.toollib.Tools.logger;

/**
 * Created by Wang on 2016/07/05.
 */
public interface  LoggerInput {
    void dump(String fileName, String level, String tag, String content);
    void dump(String fileName, String content);
}
