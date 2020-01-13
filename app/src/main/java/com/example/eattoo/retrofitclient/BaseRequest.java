package com.example.eattoo.retrofitclient;

import com.google.gson.annotations.SerializedName;

class BaseRequest {
    @SerializedName("type")
    String type;
    @SerializedName("code")
    int code;
    /*@SerializedName("data")
        String data;
    */
    @SerializedName("data")
    Object data;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(SentOTPRequest.OTPRequestData data) {
        this.data = data;
    }

}
