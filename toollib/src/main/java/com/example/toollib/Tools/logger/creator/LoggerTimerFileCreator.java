package com.example.toollib.Tools.logger.creator;

import android.util.Log;

import com.example.toollib.Tools.Time.TimeTools;
import com.example.toollib.Tools.UtilFile;

import java.io.File;
import java.util.Calendar;


/**
 * Created by Wang on 2016/07/11.
 */
public class LoggerTimerFileCreator implements LoggerFileBaseCreator {
    public static final String TAG = "TAG." + LoggerTimerFileCreator.class.getName();

    OnFileCreateListener onFileCreateListener;
    int currentTime = -1;
    private File resultFile;
    private String fileName;

    public LoggerTimerFileCreator() {
        currentTime = getNowTime();
    }

    @Override
    public File getCanWriteFile(String fileName) {
        this.fileName = fileName;
        if (isNeedCreateNewFile()) {
            setNewFile();
        } else {
            if (resultFile ==null){
                String resultFileName = getFileName(getNowTime());
                String resultFilePath = UtilFile.getLoggerFilePath(resultFileName);
                resultFile = new File(resultFilePath);
            }
            Log.d(TAG, "getCanWriteFile: time same:" + currentTime);
        }
        return resultFile;
    }

    private void setNewFile() {
        if (isFileExists(resultFile)) {
            preFileWriteCompleted(resultFile);
        }
        resultFile = createNewFile();
        if (onFileCreateListener != null) {
            onFileCreateListener.onNewFileCreated(resultFile);
        }
    }

    private boolean isFileExists(File file) {
        return file != null && file.exists();
    }


    private boolean isNeedCreateNewFile() {
        int time = getNowTime();
        File file = new File(UtilFile.getLoggerFilePath(getFileName(time)));
        if (!isFileExists(file)) {
            return true;
        }
        return false;
    }

    private void preFileWriteCompleted(File file) {
        if (onFileCreateListener != null) {
            onFileCreateListener.onOldFileComplete(file);
        }
    }

    private int getNowTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    private File createNewFile() {
        currentTime = getNowTime() ;
        String filePath = UtilFile.getLoggerFilePath(getFileName());
        Log.d(TAG, "new log File :" + filePath);
        File result = new File(filePath);
        return result;
    }

    public void setOnFileCreateListener(OnFileCreateListener onFileCreateListener) {
        this.onFileCreateListener = onFileCreateListener;
    }

    public String getFileName() {
        return fileName + TimeTools.getToday() + "-" + currentTime + ".log";
    }

    private String getFileName(int time){
        return fileName + TimeTools.getToday() + "-" + time + ".log";
    }

}
