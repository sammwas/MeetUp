package com.example.mwas.travelguide.rest;

/**
 * Created by mwas on 9/17/17.
 */
import com.example.mwas.travelguide.models.MeetUpModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("concierge/")
    Call<MeetUpModelResponse> getConcierge(@Query("api_key") String apiKey);
}
