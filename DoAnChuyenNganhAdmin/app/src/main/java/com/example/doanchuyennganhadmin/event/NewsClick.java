package com.example.doanchuyennganhadmin.event;

import com.example.doanchuyennganhadmin.model.NewsModel;

public class NewsClick {
    boolean success;
    private NewsModel newsModel;

    public NewsClick(boolean success, NewsModel newsModel) {
        this.success = success;
        this.newsModel = newsModel;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public NewsModel getNewsModel(){
        return newsModel;
    }

    public void setNewsModel(NewsModel newsModel){
        this.newsModel = newsModel;
    }
}
