package com.pinery.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.pinery.base.util.CrashUtils;

/**
 * Application的代理类
 *
 * Created by Administrator on 2017/4/26 0026.
 */

public class BaseApplication {

    private static Application sContext;
    private static BaseApplication sInstance;
    public static String sAppName = "MyApplication";

    public static Handler mHandler = new Handler(Looper.getMainLooper());

    public static Context getInstance(){

        return sContext;
    }

    public static void register(final Application application, final String appName){
        sContext = application;
        sAppName = appName;

        new Thread(new Runnable() {
            @Override public void run() {
                CrashUtils.init(application);
                CrashUtils.getInstance(application).setDirName(appName);
            }
        }).start();


    }

    public static void unregister(){
        sContext = null;
    }



}
