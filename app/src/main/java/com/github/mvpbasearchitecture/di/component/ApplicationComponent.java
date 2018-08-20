package com.github.mvpbasearchitecture.di.component;

import android.app.Application;
import android.content.Context;

import com.github.mvpbasearchitecture.base.MainApplication;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.module.ApplicationModule;
import com.github.mvpbasearchitecture.di.module.DataModule;
import com.github.mvpbasearchitecture.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(MainApplication app);

    @ApplicationContext
    Context context();

    Application application();

    AppRepository getAppRepository();

}
