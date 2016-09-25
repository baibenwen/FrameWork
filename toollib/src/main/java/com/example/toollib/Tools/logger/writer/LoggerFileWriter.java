package com.example.toollib.Tools.logger.writer;

import com.example.toollib.Tools.logger.creator.LoggerFileBaseCreator;
import com.example.toollib.Tools.logger.creator.LoggerFileSizeCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Wang on 2016/06/24.
 * log文件实际的读写
 */
public class LoggerFileWriter implements LoggerFileBaseCreator.OnFileCreateListener {

    private static final String TAG = LoggerFileWriter.class.getName();
    private File logFile;
    private FileWriter fileWriter;
    private LoggerFileBaseCreator fileCreator;
    private String fileStartContent;
    private int fileWriteCount ;
    private boolean isFileCountEnable ;

    public LoggerFileWriter() {
        fileCreator = new LoggerFileSizeCreator();
        fileCreator.setOnFileCreateListener(this);
        isFileCountEnable = false ;
        fileWriteCount = 0 ;
    }

    public void setFileCountEnable(boolean fileCountEnable) {
        isFileCountEnable = fileCountEnable;
    }

    public void setFileCreator(LoggerFileBaseCreator fileCreator) {
        this.fileCreator = fileCreator;
        this.fileCreator.setOnFileCreateListener(this);
    }

    public void setFileHeader(String fileHeader) {
        this.fileStartContent = fileHeader;
    }

    public synchronized void writeFile(String fileName, String content) {
        logFile = fileCreator.getCanWriteFile(fileName);
        initFileWrite();
        write(content);
    }

    private void initFileWrite() {
        try {
            fileWriter = new FileWriter(logFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void write(String content) {
        fileWriteCount++;
        try {
            fileWriter.append(content + "\n");
            fileWriter.flush();
            fileWriter.close();
            fileWriter = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNewFileCreated(File file) {
        writeFileFirstContent(file);
        fileWriteCount = 0;
    }

    @Override
    public void onOldFileComplete(File oldFile) {
        if (isFileCountEnable) {
            writeCount(oldFile);
        }
    }

    private void writeCount(File file) {
        synchronized (file) {
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.append("file write count" + fileWriteCount + "\n");
                fileWriter.flush();
                fileWriter.close();
                fileWriter = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFileFirstContent(File file) {
        logFile = file;
        initFileWrite();
        write("******************\n" + fileStartContent + "\n******************");
    }


}
