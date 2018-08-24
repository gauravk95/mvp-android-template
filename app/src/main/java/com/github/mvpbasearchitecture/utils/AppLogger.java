package com.github.mvpbasearchitecture.utils;

import android.util.Log;

import com.github.mvpbasearchitecture.BuildConfig;

/**
 * An App logger to only log in Debug mode
 *
 * Created by gk
 */

public class AppLogger {

    private static boolean isDebugMode = true;

    public static void init(){
        if (!BuildConfig.DEBUG){
            isDebugMode = false;
        }
    }

    public static void d(String tag, String msg){
        if(isDebugMode)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg){
        if(isDebugMode)
            Log.e(tag, msg);
    }

    public static void w(String tag, String msg){
        if(isDebugMode)
            Log.w(tag, msg);
    }

    public static void i(String tag, String msg){
        if(isDebugMode)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg){
        if(isDebugMode)
            Log.v(tag, msg);
    }

}
