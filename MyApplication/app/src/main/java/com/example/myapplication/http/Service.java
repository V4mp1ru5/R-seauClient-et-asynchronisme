package com.example.myapplication.http;
import com.example.myapplication.Model.Complexe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface
Service {
    @GET("exos/truc/complexe")
    Call<Complexe> listRepos(@Query("name") String name);
}
