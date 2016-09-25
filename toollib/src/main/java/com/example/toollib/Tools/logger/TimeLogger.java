package com.example.toollib.Tools.logger;


import com.example.toollib.Tools.Time.TimeTools;
import com.example.toollib.Tools.logger.creator.LoggerTimerFileCreator;
import com.example.toollib.Tools.logger.writer.LoggerFileWriter;

/**
 * Created by Wang on 2016/07/11.
 */
public class TimeLogger implements LoggerInput {
    public static final String TAG = "TAG." + TimeLogger.class.getName();

    private LoggerFileWriter loggerFileWriter ;

    public TimeLogger(){
        loggerFileWriter = new LoggerFileWriter();
        loggerFileWriter.setFileHeader("header");
        loggerFileWriter.setFileCreator(new LoggerTimerFileCreator());
        loggerFileWriter.setFileCountEnable(true);
    }

    public void dump(String fileName, String level, String tag, String content) {
        assert false : "content == null";
    }

    @Override
    public void dump(String fileName, String content) {
        String result = TimeTools.getNowTime(TimeTools.HH_MM_SS_SS) + "  "  + content;
        loggerFileWriter.writeFile(fileName , result);
    }
}
