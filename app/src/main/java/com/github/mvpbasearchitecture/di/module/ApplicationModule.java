package com.github.mvpbasearchitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.github.mvpbasearchitecture.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

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
