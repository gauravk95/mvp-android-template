package com.github.mvpbasearchitecture.network;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gk
 */

@Singleton
public class RetrofitHelper {

    private final RetrofitHelper instance = null;
    private APIService mAPIService;

    @Inject
    public RetrofitHelper(APIService service){
       this.mAPIService = service;
    }

    public APIService getApiService() {
        return mAPIService;
    }

}
