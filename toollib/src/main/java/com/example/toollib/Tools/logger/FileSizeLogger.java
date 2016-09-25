package com.example.toollib.Tools.logger;


import com.example.toollib.Tools.Time.TimeTools;
import com.example.toollib.Tools.logger.writer.LoggerFileWriter;

/**
 * Created by Wang on 2016/06/24.
 * 控制log到文件的输入
 */
public class FileSizeLogger {

    private static final String TAG = FileSizeLogger.class.getName();
    static FileSizeLogger fileSizeLogger;

    boolean enable = true ;
    //附加信息
    String fileNamePrefix ;
    LoggerFileWriter loggerFileWriter;

    public static FileSizeLogger getInstance(){
        if (fileSizeLogger == null) {
            fileSizeLogger = new FileSizeLogger();
        }
        return fileSizeLogger;
    }

    private FileSizeLogger(){
        loggerFileWriter = new LoggerFileWriter() ;
    }

    public void init(String loggerFileNamePrefix , String fileHeader){
        this.fileNamePrefix = loggerFileNamePrefix ;
        loggerFileWriter.setFileHeader(fileHeader);
    }


    public void setEnable(boolean enable){
        this.enable = enable ;
    }

      public void dump(String level ,String tag , String msg){
        if (enable){
            String fileName = fileNamePrefix + "_" + TimeTools.getToday();
            String content = TimeTools.getNowTime(TimeTools.HH_MM_SS_SS) + "  " + level + "  " + tag + "   " + msg;
            loggerFileWriter.writeFile(fileName, content);
        }
    }


}
