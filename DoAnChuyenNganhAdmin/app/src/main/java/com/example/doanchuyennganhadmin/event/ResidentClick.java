package com.example.doanchuyennganhadmin.event;

import com.example.doanchuyennganhadmin.model.ResidentModel;

public class ResidentClick {
    boolean success;
    private ResidentModel residentModel;

    public ResidentClick(boolean success, ResidentModel residentModel) {
        this.success = success;
        this.residentModel = residentModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResidentModel getResidentModel() {
        return residentModel;
    }

    public void setResidentModel(ResidentModel residentModel) {
        this.residentModel = residentModel;
    }
}


