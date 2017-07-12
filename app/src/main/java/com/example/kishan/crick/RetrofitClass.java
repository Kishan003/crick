package com.example.kishan.crick;

import android.telecom.Call;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kishan on 12/07/17.
 */

public class RetrofitClass {

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    public HttpLoggingInterceptor getInterceptor() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(getInterceptor()).build();

    Retrofit retrofitClass = new Retrofit.Builder()
            .baseUrl("http://cricapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
    CrickApi service = retrofitClass.create(CrickApi.class);

    public CrickApi getService() {
        return service;
    }
}

