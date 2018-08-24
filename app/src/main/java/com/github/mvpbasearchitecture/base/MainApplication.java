package com.github.mvpbasearchitecture.base;

import android.app.Application;
import android.content.Context;

import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.di.component.ApplicationComponent;
import com.github.mvpbasearchitecture.di.component.DaggerApplicationComponent;
import com.github.mvpbasearchitecture.di.module.ApplicationModule;
import com.github.mvpbasearchitecture.di.module.DataModule;
import com.github.mvpbasearchitecture.di.module.NetworkModule;
import com.github.mvpbasearchitecture.utils.AppLogger;

import javax.inject.Inject;

/**
 * Entry place when application start
 * Good place to initialize stuff that has an Application Scope
 *
 * Created by gk
 */

public class MainApplication extends Application {

    @Inject
    AppRepository mRepository;

    private static Application sInstance;

    private ApplicationComponent mApplicationComponent;

    // Anywhere in the application where an instance is required, this method
    // can be used to retrieve it.
    public static Application getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .networkModule(new NetworkModule())
                .build();

        mApplicationComponent.inject(this);

        sInstance = this;

        ((MainApplication) sInstance).initializeInstance();

    }

    // Here we do one-off initialisation which should apply to all activities
    // in the application.
    protected void initializeInstance() {
        //globally initialize the App Logger
        AppLogger.init();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
