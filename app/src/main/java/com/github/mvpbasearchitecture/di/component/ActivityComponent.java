package com.github.mvpbasearchitecture.di.component;

import com.github.mvpbasearchitecture.di.PerActivity;
import com.github.mvpbasearchitecture.di.module.ActivityModule;
import com.github.mvpbasearchitecture.ui.main.MainActivity;
import com.github.mvpbasearchitecture.ui.main.MainFragment;

import dagger.Component;

/**
 * Activity component connecting modules that have Activity scope
 * 
 * Created by gk.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(MainFragment fragment);

}
