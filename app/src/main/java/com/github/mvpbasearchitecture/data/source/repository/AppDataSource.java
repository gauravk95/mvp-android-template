package com.github.mvpbasearchitecture.data.source.repository;

import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gk
 */

public interface AppDataSource {

    Flowable<List<Item>> getItemList();

    void updateItemList(List<Item> items);

}
