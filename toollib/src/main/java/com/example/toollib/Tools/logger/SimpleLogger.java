package com.example.toollib.Tools.logger;

import com.example.toollib.Tools.Time.TimeTools;
import com.example.toollib.Tools.logger.writer.LoggerFileWriter;

/**
 * Created by Wang on 2016/07/05.
 */
public class SimpleLogger implements LoggerInput {
    public static final String TAG = "TAG." + SimpleLogger.class.getName();

    LoggerFileWriter loggerFileWriter ;

    public SimpleLogger() {
        loggerFileWriter = new LoggerFileWriter();
    }

    @Override
    public void dump(String fileName, String level, String tag, String content) {

    }

    @Override
    public void dump(String fileName, String content) {
        String result = TimeTools.getNowTime(TimeTools.HH_MM_SS_SS) + "  "  + content;
        loggerFileWriter.writeFile(fileName , result);
    }

}
