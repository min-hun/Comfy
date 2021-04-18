package com.example.doanchuyennganhadmin.model;

public class ResidentModel {
         String account, apartment, block, cmnd, email, idbusiness, owner, password, phone;

    public ResidentModel() {
    }

    public ResidentModel(String account, String apartment, String block, String cmnd, String email, String idbusiness, String owner, String password, String phone) {
        this.account = account;
        this.apartment = apartment;
        this.block = block;
        this.cmnd = cmnd;
        this.email = email;
        this.idbusiness = idbusiness;
        this.owner = owner;
        this.password = password;
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
        this.owner = owner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

