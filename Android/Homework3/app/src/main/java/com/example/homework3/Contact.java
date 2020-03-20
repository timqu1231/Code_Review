package com.example.homework3;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String street;
    private String city;

    public Contact(String name, String phone, String email, String street, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
