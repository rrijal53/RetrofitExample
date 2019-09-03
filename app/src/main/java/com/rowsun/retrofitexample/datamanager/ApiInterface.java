package com.rowsun.retrofitexample.datamanager;

import com.rowsun.retrofitexample.model.LoginResponse;
import com.rowsun.retrofitexample.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by roshanrijal on 2/15/18.
 */

public interface ApiInterface {
    @POST("/api.php")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("action")String s,
                              @Field("username")String user,
                              @Field("password")String password
                              );
}
