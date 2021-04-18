package com.example.doanchuyennganh.model;

public class NewsModel {
    private String newsavt, newsimg, newsday, newscontent,newstime;

    //constructor
    public NewsModel() {
    }

    public NewsModel(String newsavt, String newsimg, String newsday, String newscontent,String newstime) {
        this.newsavt = newsavt;
        this.newsimg = newsimg;
        this.newsday = newsday;
        this.newscontent = newscontent;
        this.newstime = newstime;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getNewsavt() {
        return newsavt;
    }

    public void setNewsavt(String newsavt) {
        this.newsavt = newsavt;
    }

    public String getNewsimg() {
        return newsimg;
    }

    public void setNewsimg(String newsimg) {
        this.newsimg = newsimg;
    }

    public String getNewsday() {
        return newsday;
    }

    public void setNewsday(String newsday) {
        this.newsday = newsday;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }
}
