package com.example.eattoo.retrofitclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CuisineListRequest {

    @SerializedName("code")
    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @SerializedName("data")
    @Expose
    private List<Cuisine> cuisine = null;

    public List<Cuisine> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<Cuisine> cuisine) {
        this.cuisine = cuisine;
    }

    public class Cuisine {
        @SerializedName("id")
        int id;
        @SerializedName("cusine_name")
        String cusine_name;
        @SerializedName("image_url")
        String image_url;
        @SerializedName("status")
        int status;
        @SerializedName("timestamp")
        String timestamp;
        boolean isSelected;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCusine_name() {
            return cusine_name;
        }

        public void setCusine_name(String cusine_name) {
            this.cusine_name = cusine_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }

}
