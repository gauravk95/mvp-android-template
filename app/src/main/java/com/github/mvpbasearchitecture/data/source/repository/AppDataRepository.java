package com.github.mvpbasearchitecture.data.source.repository;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.Remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class AppDataRepository implements AppRepository {

    private final AppDataSource mLocalAppDataSource;

    private final AppDataSource mRemoteAppDataSource;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    @Inject
    public AppDataRepository(@Remote AppDataSource remoteDataSource,
                             @Local AppDataSource localDataSource){
        mRemoteAppDataSource = remoteDataSource;
        mLocalAppDataSource = localDataSource;
    }

    @Override
    public Flowable<List<Item>> getItemList() {
        if (mCacheIsDirty){
            return mRemoteAppDataSource.getItemList();
        }
        return mLocalAppDataSource.getItemList();
    }
}
