package com.github.mvpbasearchitecture.data.source.local;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.github.mvpbasearchitecture.di.ApplicationContext;
import com.github.mvpbasearchitecture.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbOpenHelper{

    private final AppDatabase mDatabase;

    @Inject
    public AppDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        mDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,name)
                .build();
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}
