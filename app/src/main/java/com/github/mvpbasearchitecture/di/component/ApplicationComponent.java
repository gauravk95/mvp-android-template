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

import android.app.Application;
import android.content.Context;

import com.github.mvpbasearchitecture.base.MainApplication;
import com.github.mvpbasearchitecture.data.source.repository.AppDataRepository;
import com.github.mvpbasearchitecture.data.source.repository.AppRepository;
import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.module.ApplicationModule;
import com.github.mvpbasearchitecture.di.module.DataModule;
import com.github.mvpbasearchitecture.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application component connecting modules that have application scope
 *
 * Created by gk
 */

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(MainApplication app);

    @ApplicationContext
    Context context();

    Application application();

    AppRepository getAppRepository();

}
