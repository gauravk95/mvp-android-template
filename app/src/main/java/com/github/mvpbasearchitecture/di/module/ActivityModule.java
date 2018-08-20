package com.github.mvpbasearchitecture.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.github.mvpbasearchitecture.di.ActivityContext;
import com.github.mvpbasearchitecture.utils.rx.AppSchedulerProvider;
import com.github.mvpbasearchitecture.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gk.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
