package com.rohitpawarrrr.rohitpawar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("list?page=2&limit=20")
    Call<List<Model>> getJson();

}
