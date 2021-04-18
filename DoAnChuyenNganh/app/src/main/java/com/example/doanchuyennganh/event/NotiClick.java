package com.example.doanchuyennganh.event;

import com.example.doanchuyennganh.model.NotiModel;

public class NotiClick {
    private boolean success;
    private NotiModel notiModel;

    public NotiClick(boolean success, NotiModel notiModel) {
        this.success = success;
        this.notiModel = notiModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public NotiModel getNotiModel() {
        return notiModel;
    }

    public void setNotiModel(NotiModel notiModel) {
        this.notiModel = notiModel;
    }
}
