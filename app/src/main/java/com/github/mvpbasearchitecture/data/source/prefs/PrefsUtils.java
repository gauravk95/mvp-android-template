package com.github.mvpbasearchitecture.data.source.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefsUtils {

    //clears all the shared prefs
    public static void clearSharedPrefs(SharedPreferences sp){
        sp.edit().clear().apply();
    }

    //GENERIC PREFS UTIL
    public static long getLongSharedPref(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getLong(key, 0);
    }

    public static long getLongSharedPref(SharedPreferences sp, String key) {
        return sp.getLong(key, 0);
    }

    public static void setLongSharedPref(Context context, String key, long value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void setLongSharedPref(SharedPreferences sp, String key, long value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static int getIntSharedPref(SharedPreferences sp, String key) {
        return sp.getInt(key, 0);
    }

    public static void setIntSharedPref(SharedPreferences sp, String key, int value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static boolean getBooleanSharedPref(SharedPreferences sp, String key) {
        return sp.getBoolean(key, false);
    }

    public static void setBooleanSharedPref(SharedPreferences sp, String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String getStringSharedPref(SharedPreferences sp, String key) {
        return sp.getString(key, "");
    }

    public static void setStringSharedPref(SharedPreferences sp, String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
