package com.example.toollib.Tools.logger.appInfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.example.toollib.Tools.Appinfo.Information;


/**
 * Created by Wang on 2016/06/27.
 *
 */
public class AppInformation {

    static AppInformation appInformation;

    String serialNum= "unknown serial num";
    String softVersion = "unknownSoftVersion";
    String currentAppPackageName = "unknown package name";
    int systemVersion = -1;

    Context context;
    Information hardWareInformation ;

    public static AppInformation getInstance(Context context) {
        if (appInformation == null) {
            appInformation = new AppInformation(context);
        }
        return appInformation;
    }

    public AppInformation(Context context) {
        this.context = context;
    }

    public void initAndSetData() {
        hardWareInformation = new Information(context);
        setData();
    }

    void setData(){
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            softVersion = packInfo.versionName;
            currentAppPackageName = packInfo.applicationInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        systemVersion = Build.VERSION.SDK_INT;
        serialNum = (String) hardWareInformation.getInformation();
    }


    @Override
    public String toString() {
        return "sysinfo\nwifiMac:" + serialNum + "\nsoftVersion:" + softVersion + "\npacklageName:" + currentAppPackageName + "\nsysVersion:" + systemVersion ;
    }
}
