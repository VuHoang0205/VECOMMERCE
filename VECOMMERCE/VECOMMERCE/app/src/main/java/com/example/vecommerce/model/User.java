package com.example.vecommerce.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.vecommerce.BR;
import java.io.Serializable;


public class User extends BaseObservable implements Serializable {
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

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    @Bindable
    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
        notifyPropertyChanged(BR.rePassword);
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
