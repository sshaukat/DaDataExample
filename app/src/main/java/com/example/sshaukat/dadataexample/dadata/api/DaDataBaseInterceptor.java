package com.example.sshaukat.dadataexample.dadata.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class DaDataBaseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Token " + DaDataApiService.DADATA_API_KEY)
                .build();
        Response response = chain.proceed(request);

        Log.d("BaseInterceptor", request.toString());
        return response;
    }
}
