package com.example.vecommerce.model;

public class User {
    private String name = "";
    private String address = "";
    private String email = "";
    private String mobileNumber = "";
    private String password = "";
    private String rePassword = "";

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

//    public User(String name, String address, String email, String mobileNumber, String password, String rePassword) {
//        this.name = name;
//        this.address = address;
//        this.email = email;
//        this.mobileNumber = mobileNumber;
//        this.password = password;
//        this.rePassword = rePassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void bindData(String name, String address, String email, String mobileNumber, String password, String rePassword) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.rePassword = rePassword;
    }
}
