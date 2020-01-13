package com.example.eattoo.retrofitclient;

import com.google.gson.annotations.SerializedName;

public class VerifyOTPRequest extends BaseRequest {
    class RespondData {
        @SerializedName("mobile")
        String mobile;
    }
}
