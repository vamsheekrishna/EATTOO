package com.example.eattoo.retrofitclient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EatTooV1 {
    public static String BASE_URL = "http://13.232.219.13/v1/api/";

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST(SentOTP.URL)
    Call<SentOTPRequest> sentOTP(@Field("mobile") String number);

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST(VerifyOTP.URL)
    Call<VerifyOTPRequest> verifyOTP(@Field("mobile") String number, @Field("otp") String otp);

    @Headers({"Accept: application/json"})
    @GET(Cuisine.URL)
    Call<CuisineListRequest> getCuisineList();


    interface SentOTP {
        String URL = "sentotp";
        String key1_mobile ="mobile";
    }

    interface VerifyOTP {
        String URL = "verifyotp";
        String key1_mobile ="mobile";
        String key2_otp ="otp";
    }

    interface Cuisine {
        String URL = "cusine";
    }
}
