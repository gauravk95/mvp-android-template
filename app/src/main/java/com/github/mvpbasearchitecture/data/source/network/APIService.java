package com.github.mvpbasearchitecture.data.source.network;

import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Retrofit API services to connect to server
 *
 * Created by gk
 */

public interface APIService {

    @GET("itemList")
    Flowable<ResponseItemHolder> getItemList();

}
