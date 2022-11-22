package com.example.sembakomobile.API;

import com.example.sembakomobile.Model.Retrofit.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceLogin {
    @FormUrlEncoded
    @POST("retrieve.php")
    Call<ResponseModel> loginResponse(
            @Field("Username") String Username,
            @Field("Password") String Password
    );

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> registerResponse(
            @Field("NamaPembeli") String NamaPembeli,
            @Field("Alamat") String Alamat,
            @Field("no_hp") String no_hp,
            @Field("Username") String Username,
            @Field("Password") String Password
    );
}
