package com.partharoypc.retrofitapp.nwtwork;

import com.partharoypc.retrofitapp.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInstance {

    @GET("/posts")
    Call<List<Model>> getPosts();
}
