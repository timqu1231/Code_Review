package com.example.navigationdrawer.APIClient;

import android.provider.CallLog;

import com.example.navigationdrawer.Response.DataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("places")
    Call<List<DataResponse>> getPlaces();

    @GET("places")
    Call<List<DataResponse>> getPlacesWithQuery(@Query("location") String location, @Query("type") String type);

}
