package com.github.mvpbasearchitecture.di.module;

import com.github.mvpbasearchitecture.data.source.local.AppDatabase;
import com.github.mvpbasearchitecture.data.source.local.AppDbOpenHelper;
import com.github.mvpbasearchitecture.data.source.local.AppLocalDataSource;
import com.github.mvpbasearchitecture.data.source.prefs.AppPreferencesHelper;
import com.github.mvpbasearchitecture.data.source.prefs.PreferencesHelper;
import com.github.mvpbasearchitecture.data.source.remote.AppRemoteDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.di.DatabaseInfo;
import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.PreferenceInfo;
import com.github.mvpbasearchitecture.di.Remote;
import com.github.mvpbasearchitecture.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    AppDatabase provideAppDb(AppDbOpenHelper appDbOpenHelper) {
        return appDbOpenHelper.getDatabase();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

}
