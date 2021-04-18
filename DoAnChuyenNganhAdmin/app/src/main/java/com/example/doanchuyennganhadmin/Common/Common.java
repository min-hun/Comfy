package com.example.doanchuyennganhadmin.Common;

import com.example.doanchuyennganhadmin.model.AdminModel;
import com.example.doanchuyennganhadmin.model.NewsModel;
import com.example.doanchuyennganhadmin.model.ResidentModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Common {
    public static final String NEWS_REFERENCE = "news";
    public static final String ADMIN_REFERENCE = "Admin";
    public static final String RESIDENT_REF = "User";
    public static NewsModel NewsClick ;
    public static AdminModel currentAdmin;
    public static ResidentModel ResidentClick;

    public static String getcurrentDay(){
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }
    public static String getcurrentTime(){
        return new SimpleDateFormat("HH:mm",Locale.getDefault()).format(new Date());
    }
    public static String getDayNews(){
        return new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).format(new Date());
    }
}