package com.example.doanchuyennganhadmin.model;

public class AdminModel {
    private String account,password,adminname,contact,avt,namsinh,email,diachi;

    public AdminModel() {
    }

    public AdminModel(String account, String password, String adminname, String contact, String avt, String namsinh, String email, String diachi) {
        this.account = account;
        this.password = password;
        this.adminname = adminname;
        this.contact = contact;
        this.avt = avt;
        this.namsinh = namsinh;
        this.email = email;
        this.diachi = diachi;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }
}
