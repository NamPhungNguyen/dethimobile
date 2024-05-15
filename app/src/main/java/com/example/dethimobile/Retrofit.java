package com.example.dethimobile;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    public static retrofit2.Retrofit retrofit;
    public static retrofit2.Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
