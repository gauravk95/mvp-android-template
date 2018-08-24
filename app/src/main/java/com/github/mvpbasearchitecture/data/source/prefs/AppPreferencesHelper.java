/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.github.mvpbasearchitecture.data.source.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

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

    @Override
    public boolean getBoolean(@NonNull String key) {
        return PrefsUtils.getBooleanSharedPref(mPrefs,key);
    }

    @Override
    public long getLong(@NonNull String key) {
        return PrefsUtils.getLongSharedPref(mPrefs,key);
    }

    @Override
    public int getInt(@NonNull String key) {
        return PrefsUtils.getIntSharedPref(mPrefs,key);
    }

    @Override
    public String getString(@NonNull String key) {
        return PrefsUtils.getStringSharedPref(mPrefs, key);
    }

    @Override
    public void setBoolean(@NonNull String key, boolean value) {
        PrefsUtils.setBooleanSharedPref(mPrefs,key,value);
    }

    @Override
    public void setLong(@NonNull String key, long value) {
        PrefsUtils.setLongSharedPref(mPrefs,key,value);
    }

    @Override
    public void setInt(@NonNull String key, int value) {
        PrefsUtils.setIntSharedPref(mPrefs,key,value);
    }

    @Override
    public void getString(@NonNull String key, @NonNull String value) {
        PrefsUtils.setStringSharedPref(mPrefs,key,value);
    }

}
