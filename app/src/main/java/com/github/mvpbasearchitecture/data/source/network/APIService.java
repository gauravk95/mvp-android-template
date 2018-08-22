package com.github.mvpbasearchitecture.data.source.network;

import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface APIService {

    @GET("itemlist")
    Flowable<ResponseItemHolder> getItemList();

}
