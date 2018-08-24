package com.github.mvpbasearchitecture.data.source.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Utilities for Network related stuffs
 *
 * Created by gk
 */
public class NetworkUtils {

    // Adds token as a header to the OkHttpClient making the request.
    public static OkHttpClient getHttpClient(OkHttpClient.Builder httpClient) {
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });
        return httpClient.build();
    }

    // Adds token as a header to the OkHttpClient making the request.
    public static OkHttpClient getHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                })
                .build();

        return okHttpClient;
    }

}
