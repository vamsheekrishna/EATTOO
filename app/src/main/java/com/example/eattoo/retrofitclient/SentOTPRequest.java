package com.example.eattoo.retrofitclient;

import com.google.gson.annotations.SerializedName;

public class SentOTPRequest extends BaseRequest{

    public class OTPRequestData {
        @SerializedName("mobile")
        String mobile;
        @SerializedName("otp")
        String otp;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }
    }

}
