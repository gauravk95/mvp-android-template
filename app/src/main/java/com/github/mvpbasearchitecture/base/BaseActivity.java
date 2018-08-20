package com.github.mvpbasearchitecture.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.di.component.DaggerActivityComponent;
import com.github.mvpbasearchitecture.di.module.ActivityModule;

/**
 * Created by gk
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MainApplication) getApplication()).getComponent())
                .build();

    }

    protected ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onNewIntent(Intent intent) {
        this.setIntent(intent);
    }

}
