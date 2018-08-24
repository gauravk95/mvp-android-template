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
package com.github.mvpbasearchitecture.data.source.repository.local;

import android.support.annotation.NonNull;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.data.source.db.AppDatabase;
import com.github.mvpbasearchitecture.data.source.db.ItemDao;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Concrete implementation of a data source as a db using room.
 */
@Singleton
public class AppLocalDataSource implements AppDataSource {

    private final ItemDao mItemDao;

    @Inject
    public AppLocalDataSource(@NonNull AppDatabase mDatabase) {
        mItemDao = mDatabase.musicDao();
    }

    @Override
    public Flowable<List<Item>> getItemList() {
        return mItemDao.fetchItems();
    }

    @Override
    public void updateItemList(List<Item> items) {
        mItemDao.insertMultipleItem(items);
    }
}