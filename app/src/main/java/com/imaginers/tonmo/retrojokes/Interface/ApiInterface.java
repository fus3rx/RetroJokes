package com.imaginers.tonmo.retrojokes.Interface;

import com.imaginers.tonmo.retrojokes.Model.ServerResponse;
import com.imaginers.tonmo.retrojokes.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tonmo on 6/24/2017.
 */

public interface ApiInterface {

    @POST("/retrofit_get_post/server_side_code.php")
    Call<ServerResponse> getUserValidity(@Body User userLoginCredential);

    @GET("/retrofit_get_post/server_side_code.php")
    Call< ServerResponse> getJoke(@Query("user_id") String userId);
}
