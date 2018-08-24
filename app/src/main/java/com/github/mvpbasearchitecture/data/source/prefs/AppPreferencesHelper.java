package com.github.mvpbasearchitecture.data.source.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * An Helper class for Shared Preferences
 *
 * Created by gk.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}
