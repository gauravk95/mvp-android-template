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
package com.github.mvpbasearchitecture.di.module;

import com.github.mvpbasearchitecture.data.source.db.AppDatabase;
import com.github.mvpbasearchitecture.data.source.db.AppDbOpenHelper;
import com.github.mvpbasearchitecture.data.source.repository.local.AppLocalDataSource;
import com.github.mvpbasearchitecture.data.source.prefs.AppPreferencesHelper;
import com.github.mvpbasearchitecture.data.source.prefs.PreferencesHelper;
import com.github.mvpbasearchitecture.data.source.repository.remote.AppRemoteDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppDataRepository;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.di.DatabaseInfo;
import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.PreferenceInfo;
import com.github.mvpbasearchitecture.di.Remote;
import com.github.mvpbasearchitecture.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Modules related to data and repository
 *
 * Created by gk.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    @Local
    AppDataSource provideAppLocalDataSource(AppLocalDataSource appLocalDataSource) {
        return appLocalDataSource;
    }

    @Provides
    @Singleton
    @Remote
    AppDataSource provideAppRemoteDataSource(AppRemoteDataSource appRemoteDataSource) {
        return appRemoteDataSource;
    }

    @Provides
    @Singleton
    AppRepository provideAppRepository(AppDataRepository dataRepository) {
        return dataRepository;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDb(AppDbOpenHelper appDbOpenHelper) {
        return appDbOpenHelper.getDatabase();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

}
