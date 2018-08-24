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
