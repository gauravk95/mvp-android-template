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
