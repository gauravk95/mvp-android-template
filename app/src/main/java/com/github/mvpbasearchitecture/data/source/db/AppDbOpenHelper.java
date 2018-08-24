package com.github.mvpbasearchitecture.data.source.db;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * A DB Helper class to build Room DB
 *
 * Created by gk
 */

@Singleton
public class AppDbOpenHelper{

    private final AppDatabase mDatabase;

    @Inject
    public AppDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        mDatabase = Room.databaseBuilder(context, AppDatabase.class,name)
                .build();
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}
