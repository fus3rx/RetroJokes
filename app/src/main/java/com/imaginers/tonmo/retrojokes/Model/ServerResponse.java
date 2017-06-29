package com.imaginers.tonmo.retrojokes.Model;

/**
 * Created by tonmo on 6/24/2017.
 */

/*we are receiving jokes from server
 *thus we use getters method and response validity check to make
 *it readable from memory and notify validation checks*/

public class ServerResponse {

    boolean status;
    String message;

    public boolean isSuccess(){
        return status;
    }

    public String getMessage() {
        return message;
    }
}
