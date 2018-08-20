package com.github.mvpbasearchitecture.network;

import com.github.mvpbasearchitecture.data.models.remote.ResponseItem;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {

    @GET
    Flowable<ResponseItem> getItemList(@Query("category") String category);

}
