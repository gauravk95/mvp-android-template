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
package com.github.mvpbasearchitecture.data.source.repository;

import android.support.annotation.VisibleForTesting;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.data.source.prefs.PreferencesHelper;
import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * The central point to communicate to different data sources like DB, SERVER, SHARED PREFS
 *
 * Created by gk
 */

@Singleton
public class AppDataRepository implements AppRepository {

    private final AppDataSource mLocalAppDataSource;

    private final AppDataSource mRemoteAppDataSource;

    private final PreferencesHelper mPreferenceHelper;

    @VisibleForTesting
    List<Item> mCachedItemList;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    @VisibleForTesting
    boolean mCacheIsDirty = false;

    @Inject
    public AppDataRepository(@Remote AppDataSource remoteDataSource,
                             @Local AppDataSource localDataSource,
                             PreferencesHelper preferencesHelper) {
        mRemoteAppDataSource = remoteDataSource;
        mLocalAppDataSource = localDataSource;
        mPreferenceHelper = preferencesHelper;
    }

    @Override
    public Flowable<List<Item>> getItemList(boolean forceRemote) {
        if (forceRemote)
            return getItemFromServerDB();

        return getItemList();
    }

    @Override
    public Flowable<List<Item>> getItemList() {
        // Respond immediately with cache if available and not dirty
        if (mCachedItemList != null && !mCacheIsDirty) {
            return Flowable.just(mCachedItemList);
        }

        //if cache is dirty, get the data from server
        if (mCacheIsDirty) {
            return getItemFromServerDB();
        }
        return getItemFromLocalDB();
    }

    //get the items from the server
    private Flowable<List<Item>> getItemFromServerDB() {
        return mRemoteAppDataSource
                .getItemList()
                .doOnNext(items -> {
                    mLocalAppDataSource.updateItemList(items);
                    mCachedItemList = items;
                    mCacheIsDirty = false;
                });
    }

    //get the elements from local db, and if empty get it from sever
    private Flowable<List<Item>> getItemFromLocalDB() {
        return mLocalAppDataSource.getItemList()
                .switchIfEmpty(getItemFromServerDB())
                .flatMap(items -> {
                    if (items != null && items.size() > 0) {
                        mCachedItemList = items;
                        mCacheIsDirty = false;
                        return Flowable.just(items);
                    } else {
                        mCacheIsDirty = true;
                        return getItemFromServerDB();
                    }
                });
    }

    @Override
    public void updateItemList(List<Item> items) {
        mLocalAppDataSource.updateItemList(items);
    }

    @Override
    public void refreshItems() {
        mCacheIsDirty = true;
    }
}
