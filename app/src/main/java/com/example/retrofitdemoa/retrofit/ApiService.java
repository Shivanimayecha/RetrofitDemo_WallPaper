package com.example.retrofitdemoa.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    //for get category
    @GET("category.php?ccall=display")
    Call<String>getAllApps();

    //for wallpepar category id
    @FormUrlEncoded
    @POST("wallpaper.php?wcall=id")
    Call<String> getAllWallpepar(@Field("category_id") int category_id);
}

