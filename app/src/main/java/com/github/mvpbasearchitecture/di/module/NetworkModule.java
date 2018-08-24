/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.github.mvpbasearchitecture.di.module;

import com.github.mvpbasearchitecture.BuildConfig;
import com.github.mvpbasearchitecture.data.source.network.APIService;
import com.github.mvpbasearchitecture.data.source.network.NetworkAPIs;
import com.github.mvpbasearchitecture.data.source.network.NetworkUtils;
import com.github.mvpbasearchitecture.data.source.network.APIHelper;
import com.github.mvpbasearchitecture.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Modules related to network
 *
 * Created by gk.
 */

@Module
public class NetworkModule {

    private OkHttpClient.Builder client;

    public NetworkModule() {
    }

    public NetworkModule(OkHttpClient.Builder client) {
        this.client = client;
    }

    @Provides
    @Singleton
    Retrofit provideCall() {
        Retrofit retrofit;
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(AppConstants.NETWORK_TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                    .writeTimeout(AppConstants.NETWORK_TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                    .readTimeout(AppConstants.NETWORK_TIMEOUT_IN_SEC, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(NetworkUtils.getHttpClient(client))
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }else{
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(NetworkUtils.getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }

    @Provides
    @Singleton
    public APIService providesNetworkService(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

    @Provides
    @Singleton
    public NetworkAPIs providesRetrofitHelper(APIHelper apiHelper) {
        return apiHelper;
    }

}
