package com.github.mvpbasearchitecture.data.source.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.github.mvpbasearchitecture.data.models.local.Item;

/**
 * The Room Database that contains the Item table.
 */

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDao musicDao();
}