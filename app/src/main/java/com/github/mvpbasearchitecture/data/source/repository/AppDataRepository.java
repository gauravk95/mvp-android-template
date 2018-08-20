package com.github.mvpbasearchitecture.data.source.repository;

import com.github.mvpbasearchitecture.di.Local;
import com.github.mvpbasearchitecture.di.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

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
}
