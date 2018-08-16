package com.example.sshaukat.dadataexample.dadata.api;

import com.example.sshaukat.dadataexample.dadata.api.address.DaDataAddressRes;
import com.example.sshaukat.dadataexample.dadata.api.address.DaDataBodyReq;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DaDataApiService {

    String DADATA_API_KEY = "6cbcf44f52f7e021496932395717b955495600a4";
    String DADATA_BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/";


    @POST("address")
    Call<DaDataAddressRes> getAddressSync(@Body DaDataBodyReq body);
}
