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
package com.github.mvpbasearchitecture.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mvpbasearchitecture.di.component.ActivityComponent;
import com.github.mvpbasearchitecture.di.component.DaggerActivityComponent;
import com.github.mvpbasearchitecture.di.module.ActivityModule;

/**
 * Base activity without any MVP component
 * Used to declare Activities that are dumb and only act as holder to other fragments
 * <p>
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
