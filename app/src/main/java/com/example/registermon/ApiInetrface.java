package com.example.registermon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInetrface {
    @POST("login")
    Call<LoginPojo> loginUser(@Body LoginPost loginPost);
    @POST("register")
    Call<RegisterPojo> registerUser(@Body RegisterPost registerPost);

}
