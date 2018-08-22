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
 * Concrete implementation of a data source as a db.
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