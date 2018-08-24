/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
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
