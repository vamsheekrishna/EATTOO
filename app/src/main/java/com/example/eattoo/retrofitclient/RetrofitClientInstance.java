package com.example.eattoo.retrofitclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    static Retrofit retrofit = null;


    /**
     * Create the Retrofit Instance
     * @return
     */
    public static Retrofit getRetrofitClientInstance() {
        if(null == retrofit) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(EatTooV1.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
