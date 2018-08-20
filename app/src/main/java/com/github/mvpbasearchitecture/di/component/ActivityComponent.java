package com.github.mvpbasearchitecture.di.component;

import com.github.mvpbasearchitecture.di.PerActivity;
import com.github.mvpbasearchitecture.di.module.ActivityModule;
import com.github.mvpbasearchitecture.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by gk.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
