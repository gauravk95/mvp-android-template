package com.github.mvpbasearchitecture.data.source.local;

import android.support.annotation.NonNull;

import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Concrete implementation of a data source as a db.
 */
@Singleton
public class AppLocalDataSource implements AppDataSource {

    private final ItemDao mItemDao;

    @Inject
    public AppLocalDataSource(@NonNull AppDatabase mDatabase) {
        mItemDao = mDatabase.musicDao();
    }

}