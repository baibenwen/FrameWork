package com.example.toollib.Tools.logger.appInfo;

/**
 * Created by Wang on 2016/06/29.
 */
public enum AppType {
    MANAGER("Manager") ,
    DEVICE("Device") ,
    PLAYER("Player"),
    RECEIVER("Receiver"),
    CONTENT("Content"),
    NOTIFICATION("Notification") ,
    UNKNOWN("Unknown");
    String type ;
    AppType(String type){
        this.type = type ;
    }

    public String getType() {
        return type;
    }
}
