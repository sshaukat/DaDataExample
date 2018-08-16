package com.example.sshaukat.dadataexample.dadata.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaDataRestClient {

    public static <S> S createService(Class<S> apiServiceClass) {
        return getRetrofit().create(apiServiceClass);
    }

    private static Retrofit getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        //gson.serializeNulls(); //принудительно сериализует NULL значения

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        DaDataBaseInterceptor baseInterceptor = new DaDataBaseInterceptor();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(baseInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DaDataApiService.DADATA_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
