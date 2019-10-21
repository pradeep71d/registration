package com.example.registermon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInetrface {
    @POST("login")
    Call<LoginPojo> loginUser(@Body LoginPost loginPost);
    // here:
    //Call method is used to get response from api/server and set data in pojo class-LoginPojo
    //LoginPojo is class is to store api response
    //loginUser is method to send data on server
    // loginPost is parameters(Email,Password)which we are sending on server.
    // we already got Email,Password in on create method
    @POST("register")
    Call<RegisterPojo> registerUser(@Body RegisterPost registerPost);

}
