package com.example.doanchuyennganh.Callback;

import com.example.doanchuyennganh.model.NewsModel;

import java.util.List;

public interface CallBackNews {
    //phai co 2 truong hop. Load thanh cong / khongn thanh cong
    void onNewsLoadSuccess(List<NewsModel> newsModel); //KHi load thanh cong: Tạo list model
    void onNewsLoadFailed(String message); //Khi load thất bại: tạo tin nhắn thông báo
}

