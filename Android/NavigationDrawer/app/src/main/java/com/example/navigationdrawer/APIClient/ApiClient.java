package com.example.navigationdrawer.APIClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String Base_url = "http://192.168.254.7:8000";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory
                            .create()).build();
        }
        return retrofit;
    }


}
