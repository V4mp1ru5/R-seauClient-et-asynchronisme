package com.example.myapplication.http;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface
Service {
    @GET("exos/long/double/{chiffre}")
    Call<String> listRepos(@Path("chiffre") String chiffre);
}
