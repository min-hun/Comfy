package com.example.doanchuyennganhadmin.model;

public class NewsModel {
    private String newsuspost, newsavt, newsimg, newsday, newscontent, newstime;

    public NewsModel() {
    }

    public NewsModel(String newsuspost, String newsavt, String newsimg, String newsday, String newscontent, String newstime) {
        this.newsuspost = newsuspost;
        this.newsavt = newsavt;
        this.newsimg = newsimg;
        this.newsday = newsday;
        this.newscontent = newscontent;
        this.newstime = newstime;
    }

    public String getNewsuspost() {
        return newsuspost;
    }

    public void setNewsuspost(String newsuspost) {
        this.newsuspost = newsuspost;
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

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }
}
