package com.sumago.searchdatainrecyclerview;

public class Model {

    String name;
    String password;
    String address;
    String Mobile;

    public Model(String name, String password, String address, String mobile) {
        this.name = name;
        this.password = password;
        this.address = address;
        Mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
