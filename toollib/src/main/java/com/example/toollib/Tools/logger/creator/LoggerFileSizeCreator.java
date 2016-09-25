package com.example.toollib.Tools.logger.creator;

import android.util.Log;

import com.example.toollib.Tools.UtilFile;

import java.io.File;


/**
 * Created by Wang on 2016/06/29.
 * 检测文件是不是过大，是不是应该新建
 */
public class LoggerFileSizeCreator implements LoggerFileBaseCreator {

    private static final String TAG = LoggerFileSizeCreator.class.getName();

    private String fileName;
    //文件过大的时候会创建filename+index.log
    private int index = 0;
    private static final String fileSuffix = ".log";
    private static final long MAX_Length = 500 * 1024; // 单位byte
    private File resultFile;

    OnFileCreateListener onFileCreateListener;

    public void setOnFileCreateListener(OnFileCreateListener onFileCreateListener) {
        this.onFileCreateListener = onFileCreateListener;
    }

    private boolean isFileExists() {
        File file = new File(UtilFile.getLoggerFilePath(getFileName()));
        return file.exists();
    }

    private boolean isFileTooLarge() {
        File file = new File(UtilFile.getLoggerFilePath(getFileName()));
        return file.length() > MAX_Length;
    }

    private File createNewFile() {

        String filePath = UtilFile.getLoggerFilePath(getFileName());
        Log.d(TAG, "new log File :" + filePath);
        File result = new File(filePath);
        if (onFileCreateListener != null) {
            onFileCreateListener.onNewFileCreated(result);
        }
        return result;
    }

    @Override
    public File getCanWriteFile(String fileName) {
        this.fileName = fileName;
        if (!isFileExists()) {
            index = 0;
            resultFile = createNewFile();
        } else if (isFileTooLarge()) {
            index++;
            if (onFileCreateListener != null) {
                onFileCreateListener.onOldFileComplete(new File(UtilFile.getLoggerFilePath(getFileName())));
            }
            resultFile = createNewFile();
        } else {
            if (resultFile == null) {
                resultFile = new File(UtilFile.getLoggerFilePath(getFileName()));
            }
        }
        return resultFile;
    }


    private String getFileName() {
        return new String(fileName + "_" + index + fileSuffix);
    }

}
