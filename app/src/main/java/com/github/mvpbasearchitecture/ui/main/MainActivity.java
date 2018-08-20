package com.github.mvpbasearchitecture.ui.main;

import android.os.Bundle;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.base.BaseActivity;
import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.utils.ActivityUtils;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private ActivityComponent mActivityComponent;

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (mainFragment == null){
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment,R.id.content_frame);
        }

    }
}
