package com.example.navigationdrawer.model;

public class Venue {
    private byte[] image;
    private int userID;
    private String address;
    private String name;
    private String longitude;
    private String latitude;

    public Venue(byte[] image, String address, String name, int userID, String longitude, String latitude) {
        this.image = image;
        this.address = address;
        this.name = name;
        this.userID = userID;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLongitude(){ return longitude; }

    public void setLongitude(String longitude){ this.longitude = longitude;}

    public String getLatitude(){ return latitude; }

    public void setLatitude(String latitude){ this.latitude = latitude;}


}
