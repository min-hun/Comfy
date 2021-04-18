package com.example.doanchuyennganh.event;

import com.example.doanchuyennganh.model.UserModel;

public class InfoClick {
    private boolean success;
    private UserModel userModel;

    public InfoClick(boolean success, UserModel userModel) {
        this.success = success;
        this.userModel = userModel;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
