package com.imaginers.tonmo.retrojokes.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmo on 6/24/2017.
 */

public class RetrofitApiClient {
    private static final String BASE_URL = "http://192.168.0.100"; //address of your localhost
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder().setLenient().create();

    private RetrofitApiClient(){}  //only single instance will be created so

    //to use this class instance this static getClient method need to be use
    public static synchronized Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    /*এই মেথডের ভিতরে চেক করা হচ্ছে এই ক্লাসেরই একটা প্রাইভেট ডেটা retrofit অবজেক্টটা null কিনা।
    retrofit একটা প্রাইভেট ডেটা, এটার কোন সেটারও নাই। তাই অন্যান্য ক্লাস থেকে ইচ্ছা করলেও এই ডেটাকে
    ইনিশিয়ালাইজ করা সম্ভব না। প্রথমবার getClient() কল হবার সময় retrofit==null সত্য হবে।
    সত্য হলে এর ভিতরে retrofit কে initialize করা হয়েছে। এরপর return করে দেয়া হয়েছে।
    পরের বার আবার যদি getClient() কল করা হয় তখন এই প্রথম বার তৈরি হওয়া instance এর
    রেফারেন্সটাই রিটার্ন করে দেয়া হবে। এই যে কোন একটা ক্লাসের একটা অবজেক্টই শুধু তৈরি করা যাবে
    এটাকে Singleton Design Pattern বলে */

}
