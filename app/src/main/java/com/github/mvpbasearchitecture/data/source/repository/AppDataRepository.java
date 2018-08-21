package com.github.mvpbasearchitecture.data.source.repository;

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

    private List<Item> mCachedItemList;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = true;

    @Inject
    public AppDataRepository(@Remote AppDataSource remoteDataSource,
                             @Local AppDataSource localDataSource){
        mRemoteAppDataSource = remoteDataSource;
        mLocalAppDataSource = localDataSource;
    }

    @Override
    public Flowable<List<Item>> getItemList() {
        // Respond immediately with cache if available and not dirty
        if (mCachedItemList != null && !mCacheIsDirty) {
            return Flowable.just(mCachedItemList);
        }

        if (mCacheIsDirty){
            return getItemFromServerDB();
        }
        return getItemFromLocalDB();
    }

    private Flowable<List<Item>> getItemFromServerDB() {
        return mRemoteAppDataSource
                .getItemList()
                .doOnNext( items -> {
                    mLocalAppDataSource.updateItemList(items);
                    mCachedItemList = items;
                    mCacheIsDirty = false;
                });
    }

    private Flowable<List<Item>> getItemFromLocalDB() {
        return mLocalAppDataSource
                .getItemList()
                .doOnNext( items -> {
                    mCachedItemList = items;
                    mCacheIsDirty = false;
                });
    }

    @Override
    public void updateItemList(List<Item> items) {
        mLocalAppDataSource.updateItemList(items);
    }
}
