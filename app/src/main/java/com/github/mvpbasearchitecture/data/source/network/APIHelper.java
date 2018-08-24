package com.github.mvpbasearchitecture.data.source.network;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Helping with retrofit instance
 *
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
