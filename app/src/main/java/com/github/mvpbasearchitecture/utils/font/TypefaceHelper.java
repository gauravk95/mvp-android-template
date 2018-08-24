package com.github.mvpbasearchitecture.utils.font;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import com.github.mvpbasearchitecture.utils.AppLogger;

import java.util.Hashtable;

/**
 * Another helper function to cache and provide typeface
 *
 * Created by gk
 */

public class TypefaceHelper {
    private static final String TAG = "TypefaceHelper";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(AssetManager am, String assetPath) {
        if (!cache.containsKey(assetPath)) {
            try {
                Typeface t = Typeface.createFromAsset(am,
                        assetPath);
                cache.put(assetPath, t);
            } catch (Exception e) {
                AppLogger.e(TAG, "Could not get typeface '" + assetPath
                        + "' because " + e.getMessage());
                return null;
            }
        }
        return cache.get(assetPath);
    }
}