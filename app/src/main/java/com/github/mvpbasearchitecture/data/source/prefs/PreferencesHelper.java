package com.github.mvpbasearchitecture.data.source.prefs;

import android.support.annotation.NonNull;

/**
 * Created by gk.
 */

public interface PreferencesHelper {

    //GENERIC
    boolean getBoolean(@NonNull String key);

    long getLong(@NonNull String key);

    int getInt(@NonNull String key);

    String getString(@NonNull String key);

    void setBoolean(@NonNull String key, boolean value);

    void setLong(@NonNull String key, long value);

    void setInt(@NonNull String key, int value);

    void getString(@NonNull String key, @NonNull String value);

}
