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
package com.github.mvpbasearchitecture.ui.main;

import android.support.annotation.NonNull;

import com.github.mvpbasearchitecture.base.BaseContract;
import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.List;

/**
 * The main contract, consists of Screen specific Presenter and View interface
 *
 * Created by gk
 */
public interface MainContract {

    interface View extends BaseContract.View<Presenter> {

        void refreshItemList(@NonNull List<Item> itemList);

        void showEmptyListUI();

    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadItems(boolean refresh);

    }
}
