package com.example.doanchuyennganhadmin.callback;

import com.example.doanchuyennganhadmin.model.ResidentModel;

import java.util.List;

public interface CallBackListResident {
    void onResidentLoadSuccess(List<ResidentModel> residentModelList); //KHi load thanh cong: Tạo list model
    void onResidentLoadFailed(String message); //Khi load thất bại: tạo tin nhắn thông báo
}
