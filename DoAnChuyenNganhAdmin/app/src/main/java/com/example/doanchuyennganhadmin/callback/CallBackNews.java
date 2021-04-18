package com.example.doanchuyennganhadmin.callback;

import com.example.doanchuyennganhadmin.model.NewsModel;

import java.util.List;

public interface CallBackNews {
    void onNewsLoadSuccess(List<NewsModel> newsModel); //KHi load thanh cong: Tạo list model
    void onNewsLoadFailed(String message); //Khi load thất bại: tạo tin nhắn thông báo
}
