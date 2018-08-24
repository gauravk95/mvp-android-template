package com.github.mvpbasearchitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.github.mvpbasearchitecture.data.source.repository.AppDataRepository;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Modules related to application
 *
 * Created by gk.
 */

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
