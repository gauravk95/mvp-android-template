package com.github.mvpbasearchitecture.data.source.repository;

import android.support.annotation.VisibleForTesting;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class AppDataRepository implements AppRepository {

    private final AppDataSource mLocalAppDataSource;

    private final AppDataSource mRemoteAppDataSource;

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
                             @Local AppDataSource localDataSource) {
        mRemoteAppDataSource = remoteDataSource;
        mLocalAppDataSource = localDataSource;
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
