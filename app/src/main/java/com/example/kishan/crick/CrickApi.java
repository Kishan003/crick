package com.example.kishan.crick;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by kishan on 11/07/17.
 */

public interface CrickApi{

    @GET("/api/matches/")
    Call<Data> getmatches(@Header("apikey") String apikey);

    @GET("/api/fantasySquad")
    Call<Data> getteams(@Header("apikey") String apikey);

}
