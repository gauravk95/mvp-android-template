package com.github.mvpbasearchitecture.data.source.repository;

import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gk
 */

public interface AppRepository extends AppDataSource {

    Flowable<List<Item>> getItemList(boolean forceLocal);

    void refreshItems();
}
