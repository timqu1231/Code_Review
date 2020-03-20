package com.example.navigationdrawer.Response;

import com.google.gson.annotations.SerializedName;

public class DataResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("photo_url")
    private String photo_url;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;


//    public DataResponse(String name, String address, String photo_url) {
//        this.name = name;
//        this.address = address;
//        this.photo_url = photo_url;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongtitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
