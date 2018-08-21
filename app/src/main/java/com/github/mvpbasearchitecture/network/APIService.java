package com.github.mvpbasearchitecture.network;

import com.github.mvpbasearchitecture.data.models.remote.ResponseItemHolder;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface APIService {

    @GET
    Flowable<ResponseItemHolder> getItemList();

}
