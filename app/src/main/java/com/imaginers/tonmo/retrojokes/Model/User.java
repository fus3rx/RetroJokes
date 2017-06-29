package com.imaginers.tonmo.retrojokes.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmo on 6/24/2017.
 */

/*we are taking input of id and password
thus we use setters method in User class to make
it writable in memory and send it to server for checks*/

public class User {

    /*Gson library will search variables for using it
    * as a key but as we don't want to use userId as a
    * key so we used SerializedName to use user_Id as
    * the key because Gson search for SerializedName first*/

    @SerializedName("user_id")
    private String userId;
    @SerializedName("password")
    private String password;




    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
