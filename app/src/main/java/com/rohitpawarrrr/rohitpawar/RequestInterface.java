package com.rohitpawarrrr.rohitpawar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("file.json")
    Call<List<Model>> getJson();

}
