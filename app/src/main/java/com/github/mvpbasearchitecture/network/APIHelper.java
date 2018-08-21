package com.github.mvpbasearchitecture.network;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gk
 */

@Singleton
public class APIHelper implements NetworkAPIs {

    private APIService mAPIService;

    @Inject
    public APIHelper(APIService service){
       this.mAPIService = service;
    }

    @Override
    public APIService getAPIService() {
        return mAPIService;
    }
}