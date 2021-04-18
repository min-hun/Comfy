package com.example.doanchuyennganh.model;

public class UserModel {
    private String account, password, block, apartment, cmnd, email, idbusiness, owner, phone;

    public UserModel() {
    }

    public UserModel(String account, String password, String block, String apartment, String cmnd, String email, String idbusiness, String owner, String phone) {
        this.account = account;
        this.password = password;
        this.block = block;
        this.apartment = apartment;
        this.cmnd = cmnd;
        this.email = email;
        this.idbusiness = idbusiness;
        this.owner = owner;
        this.phone = phone;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdbusiness() {
        return idbusiness;
    }

    public void setIdbusiness(String idbusiness) {
        this.idbusiness = idbusiness;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner  = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
