package com.example.toollib.Tools.logger.creator;

import java.io.File;

/**
 * Created by Wang on 2016/07/11.
 */
public interface LoggerFileBaseCreator {

    interface OnFileCreateListener {
        void onNewFileCreated(File file) ;
        void onOldFileComplete(File file);
    }

    File getCanWriteFile(String fileName);
    void setOnFileCreateListener(OnFileCreateListener onFileCreateListener) ;
}
