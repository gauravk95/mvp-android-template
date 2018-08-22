package com.github.mvpbasearchitecture.data.source.repository.remote;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder;
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;
import com.github.mvpbasearchitecture.data.source.network.NetworkAPIs;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;


/**
 * Concrete implementation of a data source as a db.
 */
@Singleton
public class AppRemoteDataSource implements AppDataSource {

    private final NetworkAPIs mNetworkAPIs;

    @Inject
    public AppRemoteDataSource(NetworkAPIs api) {
        this.mNetworkAPIs = api;
    }

    @Override
    public Flowable<List<Item>> getItemList() {
        return mNetworkAPIs.getAPIService()
                .getItemList()
                .map(ResponseItemHolder::getItems);
    }

    @Override
    public void updateItemList(List<Item> items) {
        //do nothing
    }
}