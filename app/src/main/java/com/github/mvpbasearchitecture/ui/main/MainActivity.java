package com.github.mvpbasearchitecture.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.base.MainApplication;
import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.di.component.DaggerActivityComponent;
import com.github.mvpbasearchitecture.di.module.ActivityModule;

public class MainActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MainApplication) getApplication()).getComponent())
                .build();

        mActivityComponent.inject(this);
    }
}
